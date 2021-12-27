package com.erhanask.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase db = this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR,age INT)");

            //db.execSQL("INSERT INTO musicians (name,age) VALUES('İlhami',52)");
            //db.execSQL("INSERT INTO musicians (name,age) VALUES('Asiye',49)");
            //db.execSQL("INSERT INTO musicians (name,age) VALUES('Erhan',20)");

            Cursor cursor = db.rawQuery("SELECT * FROM musicians",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()){
                System.out.println("Name : "+cursor.getString(nameIx));
                System.out.println("Age : "+cursor.getInt(ageIx));
                System.out.println("Id : "+cursor.getInt(idIx));
            }

            cursor.close();


        }catch (Exception e) {
            e.printStackTrace();
        }



    }

}