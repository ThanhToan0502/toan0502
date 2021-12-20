package vn.edu.stu.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AppDatabase db;
    private ListView lv;
    private ArrayAdapter<Sach> adapter;
    ArrayList<Sach> dsSach;
    Button btnThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(this,AppDatabase.class,"qlsach.sqlite")
                .allowMainThreadQueries()
                .build();

        SachDao sachDao = db.sachDao();


        khoitao(sachDao);
        dsSach= new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsSach);

        lv = findViewById(R.id.listviewsach);
        btnThem = findViewById(R.id.btnThem);
        lv.setAdapter(adapter);

        dsSach.addAll(db.sachDao().getAll());


        lv.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position>=0 && position<dsSach.size()){
                            Sach sach=dsSach.get(position);
                            int deletedRowCount=db.sachDao().delete(sach);
                            if (deletedRowCount>0){
                                dsSach.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        }
                        return true;
                    }
                }
        );

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,ThemActivity.class);
                    startActivity(intent);
                }
        });
    }




    private void khoitao(SachDao sachDao){
        sachDao.deleteAll();
        sachDao.insert(
                new Sach(1,"Nam","asd",1998),
                new Sach(2,"Nam","asd",1998),
                new Sach(3,"Nam","asd",1998),
                new Sach(4,"Nam","asd",1998),
                new Sach(5,"Nam","asd",1998),
                new Sach(6,"Nam","asd",1998),
                new Sach(7,"Nam","asd",1998),
                new Sach(8,"Nam","asd",1998)
        );
    }
}