package com.example.rushikesh.listmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Open_existing extends AppCompatActivity {
    TextView txt2;
    String val2,val3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_open_existing );

        txt2 = (TextView) findViewById ( R.id.resTxt );
        Intent intent = getIntent();

        val2 = intent.getStringExtra(Create_New.EXTRA_MESSAGE);
        txt2.setText (val2);

        Intent intent1 = getIntent();
        val3 = intent1.getStringExtra(MainActivity.EXTRA_MESSAGE_NEW);

        txt2.setText(val3);
    }


}
