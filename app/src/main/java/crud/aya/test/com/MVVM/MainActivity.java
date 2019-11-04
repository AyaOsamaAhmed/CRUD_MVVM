package crud.aya.test.com.MVVM;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import crud.aya.test.com.R;
import crud.aya.test.com.Room.UserEntity;
import crud.aya.test.com.User.UserAdapter;
import crud.aya.test.com.User.UserAdd;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
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
        }else{
            Toast.makeText(this, "Not Save", Toast.LENGTH_SHORT).show();
        }
    }
}
