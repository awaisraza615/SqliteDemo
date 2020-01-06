package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button BtnSave,BtnDelete,BtnUpdate;
    EditText TxtId,TxtName,TxtEmail,TxtAdd,TxtPhone;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSave = (Button)findViewById(R.id.btnSave);
        BtnDelete = (Button)findViewById(R.id.btnDelete);
        BtnUpdate = (Button)findViewById(R.id.btnUpdate);

        TxtId = (EditText)findViewById(R.id.txtId);
        TxtName = (EditText)findViewById(R.id.txtName);
        TxtEmail = (EditText)findViewById(R.id.txtEmail);
        TxtAdd = (EditText)findViewById(R.id.txtAdd);
        TxtPhone = (EditText)findViewById(R.id.txtPhone);
        openHelper = new DatabaseHelper(this);
        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = TxtName.getText().toString();
                String email = TxtEmail.getText().toString();
                String address = TxtAdd.getText().toString();
                String phone = TxtPhone.getText().toString();
                db = openHelper.getWritableDatabase();

                saveData(name,email,address,phone);



            }
        });



    }
    public void saveData(String name,String email,String address,String phone)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLS_2,name);
        contentValues.put(DatabaseHelper.COLS_3,email);
        contentValues.put(DatabaseHelper.COLS_4,address);
        contentValues.put(DatabaseHelper.COLS_5,phone);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
        Toast.makeText(MainActivity.this, "Data Saved Successfully...", Toast.LENGTH_SHORT).show();

    }
}
