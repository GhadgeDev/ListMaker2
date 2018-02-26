package com.example.rushikesh.listmaker;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Create_New extends AppCompatActivity {
    DataBaseHelper mydb;
    Button BtnSave, Btnread;
    public EditText txtTITLE, txtLIST;
    public static final String EXTRA_MESSAGE = "com.example.rushikesh.listmaker.MESSAGE";
    public TextView txt;
    String txtval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_create__new );
        mydb = new DataBaseHelper ( this ) {

        };
        txt = (TextView) findViewById ( R.id.title_text );
        txtTITLE = (EditText) findViewById ( R.id.TITLE );
        txtLIST = (EditText) findViewById ( R.id.LIST );


        Btnread = (Button) findViewById ( R.id.idBtnRead );
        Btnread.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                ClickMe ();
            }
        } );
        BtnSave = (Button) findViewById ( R.id.idBtnSave );
        BtnSave.setOnClickListener ( new View.OnClickListener () {
                                         @Override
                                         public void onClick(View v) {
                                             clickMe ();
                                         }
                                     }

        );
    }

    private void clickMe() {
        String TITLE = txtTITLE.getText ().toString ();
        String LIST = txtLIST.getText ().toString ();
        Boolean result;
        result = mydb.insertData ( TITLE, LIST );
        if (result == true)
            Toast.makeText ( this, "saved", Toast.LENGTH_SHORT ).show ();
        else
            Toast.makeText ( this, "saved", Toast.LENGTH_SHORT ).show ();

    }

    private void ClickMe() {
        Cursor res = mydb.getAllData ();
        StringBuffer stringBuffer = new StringBuffer ();
        if (res != null && res.getCount () > 0) {
            while (res.moveToNext ()) {
                stringBuffer.append ( "\b TITAL :-" + res.getString ( 0 ) + "\n" );
                stringBuffer.append ( "List :-" + res.getString ( 1 ) + "\n" );
            }
            txt.setText ( stringBuffer.toString () );
            Toast.makeText ( this, "Data retrived", Toast.LENGTH_SHORT ).show ();
        } else {
            Toast.makeText ( this, "Data retrived", Toast.LENGTH_SHORT ).show ();
        }
        Intent i = new Intent ( this, Open_existing.class );
        txtval = txt.getText ().toString ();
        i.putExtra (EXTRA_MESSAGE, txtval );
        startActivity ( i );
        finish ();
    }

}

