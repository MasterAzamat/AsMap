package com.example.azaat.asmap;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Azaat on 22.02.2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "myDataBase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table mytable ("
                + "_id integer primary key autoincrement,"
                + "image integer,"
                + "name text,"
                + "des text,"
                + "price number" +");");
        ContentValues contentValues = new ContentValues();
        contentValues.put("image",R.drawable.image1);
        contentValues.put("name","Хлеб");
        contentValues.put("des","Это очень хорошый хлеб которую я попробовал ");
        contentValues.put("price",2000);
        sqLiteDatabase.insert("mytable",null,contentValues);
        contentValues = new ContentValues();
        contentValues.put("image",R.drawable.image2);
        contentValues.put("name","Фрукты");
        contentValues.put("des","Это очень хорошый фрукт которую я попробовал ");
        contentValues.put("price",1000);
        sqLiteDatabase.insert("mytable",null,contentValues);
        contentValues = new ContentValues();
        contentValues.put("image",R.drawable.image3);
        contentValues.put("name","Овощи");
        contentValues.put("des","Это очень хорошый овощ которую я попробовал ");
        contentValues.put("price",500);
        sqLiteDatabase.insert("mytable",null,contentValues);
        contentValues = new ContentValues();
        contentValues.put("image",R.drawable.image4);
        contentValues.put("name","Продукты");
        contentValues.put("des","Это очень хорошый продукт которую я попробовал ");
        contentValues.put("price",2000);
        sqLiteDatabase.insert("mytable",null,contentValues);

        sqLiteDatabase.execSQL("create table basket ("
                + "_id integer primary key autoincrement,"
                + "image integer,"
                + "name text,"
                + "des text,"
                + "price number,"
                + "count integer"+");");
//        contentValues = new ContentValues();
//        contentValues.put("image",R.drawable.image4);
//        contentValues.put("name","Продукты");
//        contentValues.put("des","Это очень хорошый продукт которую я попробовал ");
//        contentValues.put("price",2000);
//        contentValues.put("count",2);
//        sqLiteDatabase.insert("basket",null,contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
