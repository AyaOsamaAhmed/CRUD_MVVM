package crud.aya.test.com.MVVM;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import crud.aya.test.com.Room.UserDao;
import crud.aya.test.com.Room.UserDatabase;
import crud.aya.test.com.Room.UserEntity;

public class UserRepository {

    private UserDao  userDao;
    private LiveData<List<UserEntity>> listLiveData;

    public UserRepository (Application application){
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        userDao = userDatabase.userDao();
        listLiveData = userDao.getAllusers();
    }

    public void add(UserEntity userData){
        new AddAsyncTask(userDao).execute(userData);

    }

    public void edit(UserEntity userData){
        new editAsyncTask(userDao).execute(userData);
    }

    public void update(UserEntity userData){
        new updateAsyncTask(userDao).execute(userData);
    }

    public void delete (UserEntity userData){
        new deleteAsyncTask(userDao).execute(userData);
    }

    public LiveData<List<UserEntity>>  getAllUsers(){
        return listLiveData;
    }

    private static class AddAsyncTask extends AsyncTask<UserEntity, Void ,Void>{

        private UserDao userDao;

        private AddAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {

            userDao.add(userEntities[0]);
            return null;
        }
    }

    private static class editAsyncTask extends AsyncTask<UserEntity, Void ,Void>{

        private UserDao userDao;

        private editAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {

            userDao.edit(userEntities[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<UserEntity, Void ,Void>{

        private UserDao userDao;

        private updateAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {

            userDao.add(userEntities[0]);
            return null;
        }
    }


    private static class deleteAsyncTask extends AsyncTask<UserEntity, Void ,Void>{

        private UserDao userDao;

        private deleteAsyncTask(UserDao userDao){
            this.userDao=userDao;
        }
        @Override
        protected Void doInBackground(UserEntity... userEntities) {

            userDao.delete(userEntities[0]);
            return null;
        }
    }


}
