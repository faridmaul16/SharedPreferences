package com.e.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText nama,username,password;
    Button btnBuatAkun, btnKembali;
    DataHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.editTextNama);
        username =findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        dbHelper = new DataHelper(this);

        btnBuatAkun = findViewById(R.id.buttonCreateAkun);
        btnKembali = findViewById(R.id.buttonKembali);

        btnBuatAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("INSERT_INTO tbl_user (nama,username,password)VALUES"+
                        "('"+ nama.getText().toString()+"',"+"'"+password.getText().toString()+"')'");
                Toast.makeText(getApplicationContext(),"Anda Sudah Terdaftar",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
