package com.example.rushikesh.listmaker;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class launcher_icon extends AppCompatActivity {
    private final int LOGO = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_icon);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(launcher_icon.this, MainActivity.class);
                launcher_icon.this.startActivity(mainIntent);
                launcher_icon.this.finish();
            }
        }, LOGO);

    }
}
