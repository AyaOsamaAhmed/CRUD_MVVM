package crud.aya.test.com.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Callable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import crud.aya.test.com.R;

public class UserEdit extends AppCompatActivity {


    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_email)
    EditText userEmail;
    @BindView(R.id.user_age)
    EditText userAge;
    @BindView(R.id.user_notes)
    EditText userNotes;

    public static String newID = "NewID";
    public static String newName = "NewName";
    public static String newEmail="NewEmail";
    public static String newAge="NewAge";
    public static String newNotes="NewNotes";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add);
        ButterKnife.bind(this);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();
        if(intent.hasExtra(newID)){
            setTitle("Edit User");
            userName.setText(intent.getStringExtra(newName));
            userEmail.setText(intent.getStringExtra(newEmail));
            userNotes.setText(intent.getStringExtra(newNotes));
            userAge.setText(intent.getIntExtra(newAge,-1)+"");

        }
        else{ setTitle("Add User");}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.user_save,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.user_save:
                saveUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveUser() {
        String user_name , user_email , user_notes;
        Integer     user_age ;
        user_name = userName.getText().toString();
        user_email = userEmail.getText().toString();
        user_age = Integer.parseInt(userAge.getText().toString());
        user_notes = userNotes.getText().toString();

        if( validData(user_name,user_email,user_age,user_notes)){

            Intent transferData = new Intent();
            transferData.putExtra(newName,user_name);
            transferData.putExtra(newEmail,user_email);
            transferData.putExtra(newAge,user_age);
            transferData.putExtra(newNotes,user_notes);

            int id = getIntent().getIntExtra(newID,-1);
            if(id != -1 ){
                transferData.putExtra(newID,id);
            }
            setResult(RESULT_OK,transferData);
            finish();
        }

    }

    private Boolean validData(String user_name, String user_email, Integer user_age, String user_notes) {
        if(user_name.trim().isEmpty()){
            Toast.makeText(this, "please, enter User Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user_email.trim().isEmpty()){
            Toast.makeText(this, "please, enter User Email", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user_age == null){
            Toast.makeText(this, "please, enter User Age", Toast.LENGTH_SHORT).show();
            return false;
        }else if(user_notes.trim().isEmpty()){
            Toast.makeText(this, "please, enter User Notes", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
