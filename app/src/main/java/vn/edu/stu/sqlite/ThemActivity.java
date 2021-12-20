package vn.edu.stu.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.ArrayList;

public class ThemActivity extends AppCompatActivity {
    AppDatabase db;
    EditText edtMa, edtTen, edtTacgia, edtNXB;
    Button btnOK;
    ArrayList<Sach> dsSach;
    private ArrayAdapter<Sach> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsua);


        db = Room.databaseBuilder(this,AppDatabase.class,"qlsach.sqlite")
                .allowMainThreadQueries()
                .build();

        dsSach= new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsSach);

        dsSach= new ArrayList<>();
        btnOK=findViewById(R.id.btnOK);
        edtMa=findViewById(R.id.edtMa);
        edtTen=findViewById(R.id.edtTen);
        edtTacgia=findViewById(R.id.edtTacgia);
        edtNXB=findViewById(R.id.edtNXB);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer ma = Integer.parseInt(edtMa.getText().toString());
                String ten=edtTen.getText().toString();
                String tacgia=edtTacgia.getText().toString();
                Integer nxb = Integer.parseInt(edtNXB.getText().toString());

                SachDao sachDao = db.sachDao();
                Sach sach = new Sach(ma,ten,tacgia,nxb);
                sachDao.insert(
                    sach
                );
                adapter.notifyDataSetChanged();
                Intent intent = new Intent(ThemActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }

}

