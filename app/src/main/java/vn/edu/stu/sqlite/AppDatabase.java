package vn.edu.stu.sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Sach.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SachDao sachDao();
}

