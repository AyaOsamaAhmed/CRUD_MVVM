package crud.aya.test.com.MVVM;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import crud.aya.test.com.Room.UserEntity;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<UserEntity>> listLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        listLiveData = userRepository.getAllUsers();

    }

    public void add (UserEntity data){
        userRepository.add(data);
    }

    public void edit(UserEntity data){
        userRepository.edit(data);
    }

    public void update(UserEntity data){
        userRepository.update(data);
    }

    public void delete(UserEntity data){
        userRepository.delete(data);
    }

    public LiveData<List<UserEntity>> getAllUser (){
        return listLiveData;
    }
}
