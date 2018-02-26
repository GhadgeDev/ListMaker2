package com.example.rushikesh.listmaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MASTER DV on 21-02-2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="listM.db";
    public static final String TABLE_NAME ="Main_list";

    public static final String COL_1="TITAL";
    public static final String COL_2="LIST";
    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME +"(TITAL TEXT,LIST TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
   public boolean insertData(String TITAL, String LIST){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, String.valueOf(TITAL));
        contentValues.put(COL_2, String.valueOf(LIST));
        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
      }
      public Cursor getAllData(){
       SQLiteDatabase db = this.getWritableDatabase ();
       Cursor res = db.rawQuery ( "select * from "+TABLE_NAME,null );
       return res;
      }
    }