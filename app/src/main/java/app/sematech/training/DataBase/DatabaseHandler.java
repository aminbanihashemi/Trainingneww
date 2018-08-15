package app.sematech.training.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abanihashemi on 8/7/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    String tableQuery = "" +
            "CREATE TABLE students (" +
            " _id INTEGER PRIMARY KEY AUTOINCREMENT,"  +
            "name TEXT ," +
            "family TEXT " +
            ")";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableQuery);
    }
    public void insert(String name,String family){
        String insertQuery = "INSERT INTO students (name , family)" +
                "VALUES ('"+name+"','"+family+"')" ;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
        db.close();

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
