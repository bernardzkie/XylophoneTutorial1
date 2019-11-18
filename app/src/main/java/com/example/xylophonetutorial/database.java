package com.example.xylophonetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
    public static final String file_name = "smarts.db";
    public static final String Table_name = "easy";
    public static final String COL1 = "ID";
    public static final String COL2 = "tittle";
    public static final String COL3 = "note";
    public static final String Table_normal = "Normal";
    public static final String COL1_normal = "ID";
    public static final String COL2_normal = "tittle";
    public static final String COL3_normal = "note";


    public database(Context context) {
        super(context, file_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String easyname  = "CREATE TABLE " + Table_name + "( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tittle TEXT, note TEXT)";
        String normalname  = "CREATE TABLE " + Table_normal + "( ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tittle TEXT, note TEXT)";

        db.execSQL(easyname);
        db.execSQL(normalname);

    }
    public  Boolean addNormal(String data2, String data3) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        cv.put(COL2_normal, data2);
        cv.put(COL3_normal, data3);
        Long result = db.insert(Table_normal, null, cv);
        if (result == -1) {
            return false;


        }
        else
        {
            return true;
        }
    }

    public  Boolean addData(String item2, String item3) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        cv.put(COL2, item2);
        cv.put(COL3, item3);
        Long result = db.insert(Table_name, null, cv);
        if (result == -1) {
            return false;


        }
        else
        {
            return true;
        }
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + Table_name + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + Table_normal + "'");

        onCreate(db);

    }


public Cursor GetTittle(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + Table_name, null);
return data;


}


    public Cursor GetNormal(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + Table_normal, null);
        return data;


    }

}
