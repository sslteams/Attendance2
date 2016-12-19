package sslteam.kritagnya.attendance;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;


public class dbStarter extends SQLiteOpenHelper {

    public String d ;
    public final String dbname = "attendance";
    public final int dbversion = 1;
    public final String classname =  "class" ;
    public final String hour = "hour";
    public final String dateOfClass ="date";
    public final String rollno = "roll";
    public final String atd = "quesnto";
    SQLiteDatabase db;
    String dateEq = "the date is   \n" + new Date().getDate() + " - " + new Date().getMonth();

    public  String CREATE_SQL = "create table  "+dbname+"("+classname+"text,"+hour+"integer,"+dateOfClass+"text,"
            +rollno+"integer primary key,"+atd+"integer);";


    public dbStarter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_SQL);
        }
        catch (Exception e)
        {
            Log.e(d,"Error");
        }
    }

    public  void addMe(int rollCall,int attendance)
    {
        db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(classname,"cseb9");
        contentValues.put(hour,1);
        contentValues.put(dateOfClass,dateEq);
        contentValues.put(rollno,rollCall);
        contentValues.put(atd,attendance);
        db.insert(dbname,null,contentValues);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
