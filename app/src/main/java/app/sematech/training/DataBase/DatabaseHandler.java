package app.sematech.training.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abanihashemi on 8/7/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    String tableQuery = "" +
            " CREATE TABLE students ( " +
            " id INTEGER PRIMARY KEY AUTOINCREMENT , " +
            " name TEXT  ," +
            " family TEXT " +
            " )";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableQuery);
    }
    public void insert(String name,String family){
        String insertQuery = " INSERT INTO students (name,family) " +
                " VALUES(  '" + name + "' , '" + family + "'   )";



        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
        db.close();

    }
    public void delete()
    {   SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableQuery, null, null);
    }
    public List<StudentModel> getStudents(){
        List<StudentModel> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        //Order by id DESC : sort Descending
        Cursor cursor= db.rawQuery("SELECT name,family FROM students ORDER BY id DESC",null);
        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            String family = cursor.getString(1);
            StudentModel std = new StudentModel(name,family);

            students.add(std);
        }
        return students;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
