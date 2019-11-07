package crud.aya.test.com.MVVM;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.sql.DataSource;

import butterknife.BindView;
import butterknife.ButterKnife;
import crud.aya.test.com.Fragment.NavigationGraph;
import crud.aya.test.com.Paging.DataActivity;
import crud.aya.test.com.R;
import crud.aya.test.com.Room.UserEntity;
import crud.aya.test.com.User.UserAdapter;
import crud.aya.test.com.User.UserAdd;
import crud.aya.test.com.User.UserEdit;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.recycler_item)
    RecyclerView recyclerItem;

    private UserViewModel userViewModel;
    final UserAdapter userAdapter  = new UserAdapter();
    public static final int ADD_NOTE_REQUEST = 1 ;
    public static final int Edit_NOTE_REQUEST = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTitle("All User");
        // Recycle view
        recyclerItem.setLayoutManager(new LinearLayoutManager(this));
        recyclerItem.setHasFixedSize(true);
        recyclerItem.setAdapter(userAdapter);
        //
        userViewModel = new ViewModelProviders().of(this).get(UserViewModel.class);
        userViewModel.getAllUser().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                // update RecyclerView
                userAdapter.setEntityList(userEntities);
            }
        });
        //
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent user_add = new Intent(MainActivity.this, UserAdd.class);
                startActivityForResult(user_add , ADD_NOTE_REQUEST);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                userViewModel.delete(userAdapter.getUserId(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "User Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerItem);

        userAdapter.setOnItemclickLisiner(new UserAdapter.onItemClickLisiner() {
            @Override
            public void onItemClick(UserEntity userEntity) {
                Intent intent = new Intent (MainActivity.this, UserEdit.class);
                intent.putExtra(UserEdit.newID,userEntity.getId());
                intent.putExtra(UserEdit.newName,userEntity.getName());
                intent.putExtra(UserEdit.newAge,userEntity.getAge());
                intent.putExtra(UserEdit.newEmail,userEntity.getEmail());
                intent.putExtra(UserEdit.newNotes,userEntity.getNotes());
                startActivityForResult(intent,Edit_NOTE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==ADD_NOTE_REQUEST && resultCode==RESULT_OK){
            String Name = data.getStringExtra(UserAdd.newName);
            String Email = data.getStringExtra(UserAdd.newEmail);
            Integer Age = Integer.parseInt(data.getStringExtra(UserAdd.newAge));
            String Notes = data.getStringExtra(UserAdd.newNotes);

            UserEntity userEntity = new UserEntity(Name,Email,Age,Notes);
            userViewModel.add(userEntity);
            Toast.makeText(this, "Saved new user", Toast.LENGTH_SHORT).show();
        }else if(requestCode==Edit_NOTE_REQUEST && resultCode==RESULT_OK) {
            int id = data.getIntExtra(UserEdit.newID,-1);
            if(id == -1){
                Toast.makeText(this, "User can't be update", Toast.LENGTH_SHORT).show();
                return;
            }

            String Name = data.getStringExtra(UserEdit.newName);
            String Email = data.getStringExtra(UserEdit.newEmail);
            Integer Age = data.getIntExtra(UserEdit.newAge,-100);
            String Notes = data.getStringExtra(UserEdit.newNotes);
            UserEntity userEntity = new UserEntity(Name,Email,Age,Notes);
            userEntity.setId(id);
            userViewModel.edit(userEntity);
            Toast.makeText(this, "Saved edit user", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Not Save", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.FragmentView:
                fragmentView();
                return true;
            case R.id.Paging:
                pagingTest();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void pagingTest() {
        Intent paging = new Intent(MainActivity.this, DataActivity.class);
        startActivity(paging);
    }

    private void fragmentView() {

        Intent fragment = new Intent(MainActivity.this, NavigationGraph.class);
        startActivity(fragment);

    }

}
