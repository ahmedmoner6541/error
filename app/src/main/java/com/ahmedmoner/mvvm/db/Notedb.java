package com.ahmedmoner.mvvm.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ahmedmoner.mvvm.model.Note;

@Database(entities = Note.class, version = 2)
public abstract class Notedb extends RoomDatabase {

    private static Notedb instance;

    public abstract NoteDao noteDao();

    public static synchronized Notedb getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , Notedb.class, "note_database")
                    .fallbackToDestructiveMigration()// لو الفيرجن اتغير متمسحش كل الداتا
                   .allowMainThreadQueries()//هنستخدمها في مييين ثريد لو هنستخدم ار ا كس نستخدمها هنا
                    .build();
        }
        return instance;
    }

}
