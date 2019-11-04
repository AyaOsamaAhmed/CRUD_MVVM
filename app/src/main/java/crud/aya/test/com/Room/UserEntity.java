package crud.aya.test.com.Room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="user")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    private int id ;

    private String name ;
    @ColumnInfo(name = "user_email")
    private String email;

    private int age;

    private String notes;

    public UserEntity(String name, String email, int age, String notes) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.notes = notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getNotes() {
        return notes;
    }
}
