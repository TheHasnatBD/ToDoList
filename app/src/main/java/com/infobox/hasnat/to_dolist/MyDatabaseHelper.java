package com.infobox.hasnat.to_dolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hasnat on 2/27/18.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydb";
    private static final String TABLE_NAME = "hasnat_table";

    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String DETAILS = "details";
    private static final String DATE = "date";


    MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

//    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DATABASE_NAME, null, 1);
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_create = "CREATE TABLE "+TABLE_NAME+" ( "+ID+" INTEGER PRIMARY KEY, "+TITLE+" TEXT, "+DETAILS+" TEXT, "+DATE+" TEXT)";
        db.execSQL(table_create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Insert Data
    public void insertData(DataTemp dataTemp){
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, dataTemp.getTitleTemp());
        contentValues.put(DETAILS, dataTemp.getDetailsTemp());
        contentValues.put(DATE, String.valueOf(dataTemp.getDateTemp()));

        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    //get all data
    String[] getAllData(){
        SQLiteDatabase database = this.getReadableDatabase();

        String select_data = "SELECT * FROM "+TABLE_NAME;
        Cursor cursor = database.rawQuery(select_data, null);

        String[] received_data = new String[cursor.getCount()];

        cursor.moveToFirst();

        if(cursor.moveToFirst()){
            int counter = 0;
            do {
                received_data[counter] = new String (cursor.getString(cursor.getColumnIndex(TITLE)));
                received_data[counter] = cursor.getString(cursor.getColumnIndex(DETAILS));
                received_data[counter] = cursor.getString(cursor.getColumnIndex(DATE));


                //received_data[counter] = (cursor.getString(cursor.getColumnIndex(TITLE, DETAILS, DATE)), (cursor.getString(cursor.getColumnIndex(DETAILS))), (cursor.getString(cursor.getColumnIndex(DATE)));
                counter = counter+1;
            }while (cursor.moveToNext());
        }
        return received_data;
    }


}
