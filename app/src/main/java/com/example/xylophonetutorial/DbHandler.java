package com.example.xylophonetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;


public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "scoredb";

    private static final String Table_easy = "Table_Easy";
    private static final String Table_normal = "Table_Normal";
    private static final String Table_hard = "Table_Hard";


    private static final String Easy_id = "Easy_Id";
    private static final String Normal_id = "Normal_Id";
    private static final String Hard_id = "Hard_Id";


    private static final String Easy_tittle = "Easy_Tittle";
    private static final String Normal_tittle = "Normal_Tittle";
    private static final String Hard_tittle = "Hard_Tittle";


    private static final String Easy_remarks = "Easy_Remarks";
    private static final String Normal_remarks = "Normal_Remarks";
    private static final String Hard_remarks = "Hard_Remarks";


    private static final String Easy_score = "Easy_Score";
    private static final String Normal_score = "Normal_Score";
    private static final String Hard_score = "Hard_Score";
public  static  final  String easyquery_score = "query_score";
public static  final String easy_percent = "Easy_Percent";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EASY = "CREATE TABLE " + Table_easy + "("
                + Easy_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Easy_tittle + " TEXT,"
                + Easy_remarks + " TEXT,"
                + Easy_score + " INTEGER " + ")";

        String CREATE_NORMAL = "CREATE TABLE " + Table_normal + "("
                + Normal_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Normal_tittle + " TEXT,"
                + Normal_remarks + " TEXT,"
                + Normal_score + " INTEGER " + ")";
        String CREATE_HARD = "CREATE TABLE " + Table_hard + "("
                + Hard_id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Hard_tittle + " TEXT,"
                + Hard_remarks + " TEXT,"
                + Hard_score + " INTEGER " + ")";
        String CREATE_EASY_VIEW = " CREATE VIEW  " + easyquery_score + " AS SELECT " +
                "ROUND ( SUM ( " + Easy_score + " ) " + " / " + " COUNT ( " + Easy_score + " ), 3 )  " +
                " AS " + easy_percent + " FROM " + Table_easy;


        db.execSQL(CREATE_EASY);
        db.execSQL(CREATE_NORMAL);
        db.execSQL(CREATE_HARD);
        db.execSQL(CREATE_EASY_VIEW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + Table_easy);
        db.execSQL("DROP TABLE If EXISTS " + Table_normal);
        db.execSQL("DROP TABLE IF EXISTS " + Table_hard);
        db.execSQL("DROP TABLE IF EXISTS " + easyquery_score);
        // Create tables again
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details


    void InsertNormal(String tittle, String remarks, String score) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(Normal_tittle, tittle);
        cValues.put(Normal_remarks, remarks);
        cValues.put(Normal_score, score);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Table_normal, null, cValues);
        db.close();
    }


    void InsertHard(String tittle, String remarks, String score) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(Hard_tittle, tittle);
        cValues.put(Hard_remarks, remarks);
        cValues.put(Hard_score, score);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Table_hard, null, cValues);
        db.close();
    }


    void InsertEasy(String tittle, String remarks, String score) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(Easy_tittle, tittle);
        cValues.put(Easy_remarks, remarks);
        cValues.put(Easy_score, score);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Table_easy, null, cValues);
        db.close();
    }

    // Get User Details
    public ArrayList<HashMap<String, String>> Geteasy() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> EasyList = new ArrayList<>();
        String query = "SELECT Easy_Tittle, Easy_Remarks, Easy_Score FROM " + Table_easy;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("tittle", cursor.getString(cursor.getColumnIndex(Easy_tittle)));
            user.put("remarks", cursor.getString(cursor.getColumnIndex(Easy_remarks)));
            user.put("score", cursor.getString(cursor.getColumnIndex(Easy_score)));
            EasyList.add(user);
        }
        return EasyList;
    }

    // Get User Details
    public ArrayList<HashMap<String, String>> easyscore() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> scoreList = new ArrayList<>();
        String query = "SELECT * FROM " + easyquery_score;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("score", cursor.getString(cursor.getColumnIndex(easy_percent)));

        }
        return scoreList;
    }

    // Get User Details
    public ArrayList<HashMap<String, String>> Getnormal() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> NormalList = new ArrayList<>();
        String query = "SELECT Normal_Tittle, Normal_Remarks, Normal_Score FROM " + Table_normal;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("tittle", cursor.getString(cursor.getColumnIndex(Normal_tittle)));
            user.put("remarks", cursor.getString(cursor.getColumnIndex(Normal_remarks)));
            user.put("score", cursor.getString(cursor.getColumnIndex(Normal_score)));
            NormalList.add(user);
        }
        return NormalList;
    }



//CREATE VIEW "Progress" AS SELECT  round(sum(Easy.Score) /count(Easy.score) , 3)  as Easy_Average,
//round(sum(Normal.Score) / count(Normal.score), 3) as Normal_Average,
//round(sum(Hard.Score) /count(Hard.score),3) as Hard_Average
//FROM Easy, Normal, Hard




    public ArrayList<HashMap<String, String>> Gethard() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> HardList = new ArrayList<>();
        String query = "SELECT Hard_Tittle, Hard_Remarks, Hard_Score FROM " + Table_hard;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("tittle", cursor.getString(cursor.getColumnIndex(Hard_tittle)));
            user.put("remarks", cursor.getString(cursor.getColumnIndex(Hard_remarks)));
            user.put("score", cursor.getString(cursor.getColumnIndex(Hard_score)));
            HardList.add(user);
        }
        return HardList;
    }


}

/*

    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT name, location, designation FROM "+ TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_NAME, KEY_LOC, KEY_DESG}, KEY_ID+ "=?",new String[]{String.valueOf(userid)},null, null, null, null);
        if (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("designation",cursor.getString(cursor.getColumnIndex(KEY_DESG)));
            user.put("location",cursor.getString(cursor.getColumnIndex(KEY_LOC)));
            userList.add(user);
        }
        return  userList;
    }
    // Delete User Details
    public void DeleteUser(int userid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID+" = ?",new String[]{String.valueOf(userid)});
        db.close();
    }
    // Update User Details
    public int UpdateUserDetails(String location, String designation, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_LOC, location);
        cVals.put(KEY_DESG, designation);
        int count = db.update(TABLE_Users, cVals, KEY_ID+" = ?",new String[]{String.valueOf(id)});
        return  count;
    }
}
*/