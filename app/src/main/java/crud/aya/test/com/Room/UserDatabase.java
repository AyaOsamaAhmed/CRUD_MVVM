package crud.aya.test.com.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UserEntity.class} ,version = 1 , exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase instance ;

    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context){
     if(instance == null){
        instance = Room.databaseBuilder(context.getApplicationContext(),
                UserDatabase.class , "user_database")
                .fallbackToDestructiveMigration()
                .addCallback(roomcallback)
                .build();

     }
     return instance;
    }

    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void ,Void,Void>{

        private UserDao userDao;

        private PopulateDbAsyncTask(UserDatabase userDatabase){
            userDao = userDatabase.userDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            userDao.add(new UserEntity("aya","aya.com",25,"notes"));
            userDao.add(new UserEntity("osama","osama.com",65,"notes"));
            userDao.add(new UserEntity("ahmed","ahmed.com",55,"notes"));

            return null;
        }
    }
}

