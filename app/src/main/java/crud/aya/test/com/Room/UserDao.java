package crud.aya.test.com.Room;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void add(UserEntity userEntity);

    @Update
    void edit (UserEntity userEntity);

    @Delete
    void delete (UserEntity userEntity);

    @Query("SELECT notes FROM user")
    String showNotes ();

    @Query("SELECT * FROM user ORDER BY id DESC")
    LiveData<List<UserEntity>> getAllusers ();


}
