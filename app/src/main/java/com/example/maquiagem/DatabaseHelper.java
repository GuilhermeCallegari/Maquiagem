package com.example.maquiagem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String BD = "maquigemDB";
    private static int VERSAO = 1;
    private static final String TABLE_NAME = "products";
    private static final String ID = "id";
    private static final String BRAND = "brand";
    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static final String PRICE = "price";
    private static final String CURRENCY = "currency";
    private static final String IMAGE = "image_link";
    private static final String DESCRIPTION = "description";

    private Object Makeup;

    public DatabaseHelper(Context context){
        super(context, BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
            "create table products" +
                    "(id integer primary key, " +
                    "brand text, " +
                    "name text, " +
                    "type text, " +
                    "price text, " +
                    "currency varchar(5), " +
                    "image_link text, " +
                    "description text)"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int newI) {
        VERSAO = newI;
        db.execSQL("DROP TABLE IF EXISTS products");
        this.onCreate(db);
    }


    public void insertMakeup(Makeup makeup) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put((ID), Integer.toString(makeup.getId()));
        values.put(BRAND, makeup.getBrand());
        values.put(NAME, makeup.getName());
        values.put(TYPE, makeup.getType());
        values.put(PRICE, makeup.getPrice());
        values.put(CURRENCY, makeup.getCurrency());
        values.put(IMAGE, makeup.getImage_link());
        values.put(DESCRIPTION, makeup.getDescription());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Makeup> selectAll(){
        List<Makeup> returnAll = new ArrayList<Makeup>();

        String querryDB = "SELECT * FROM " + TABLE_NAME ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(querryDB, null);

        if(cursor.moveToFirst()){
            String brand, name, price, currency, image, type, description;
            int id;
            do{
                id = cursor.getInt(0);
                brand = cursor.getString(1);
                name = cursor.getString(2);
                price = cursor.getString(3);
                currency = cursor.getString(4);
                image = cursor.getString(5);
                type = cursor.getString(6);
                description = cursor.getString(7);

                Makeup makeup = new Makeup(id, brand, name, type, price, currency, image, description);
                returnAll.add(makeup);
            }while (cursor.moveToNext());
        }
        else{
            System.out.println("Tabela Vazia");
        }
        cursor.close();
        db.close();
        return returnAll;
    }
}


