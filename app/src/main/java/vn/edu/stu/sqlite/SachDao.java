package vn.edu.stu.sqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SachDao {
    @Query("select * from sach")
    List<Sach> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Sach...saches);

    @Query("delete from sach")
    void deleteAll();

    @Delete
    int delete(Sach sach);



}
