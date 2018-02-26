package com.example.rushikesh.listmaker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_NEW = "com.example.rushikesh.listmaker.MESSAGE_NEW";
    DataBaseHelper mydb;
    String resText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void create_new(View view) {

        startActivity(new Intent(MainActivity.this, Create_New.class));
    }

    public void open_existing(View view) {
        Cursor res = mydb.getAllData();
        StringBuffer stringBuffer = new StringBuffer();
        if (res != null && res.getCount() > 0) {
            while (res.moveToNext()) {
                stringBuffer.append("\b TITAL :-" + res.getString(0) + "\n");
                stringBuffer.append("List :-" + res.getString(1) + "\n");
            }
            resText = (stringBuffer.toString());
            Toast.makeText(this, "Data retrived", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data retrived", Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(MainActivity.this, Open_existing.class);
        i.putExtra(EXTRA_MESSAGE_NEW, resText);
        startActivity(i);
    }
}
