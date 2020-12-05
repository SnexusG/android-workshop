package com.example.notes.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notes.model.Note;

@Database(entities = Note.class, version = 3)
public abstract class NoteDatabase extends RoomDatabase {

    private static com.example.notes.data.NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized com.example.notes.data.NoteDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    com.example.notes.data.NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
            return instance;
    }

}
