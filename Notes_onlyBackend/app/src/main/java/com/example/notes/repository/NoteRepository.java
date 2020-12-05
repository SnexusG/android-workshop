package com.example.notes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notes.data.NoteDao;
import com.example.notes.data.NoteDatabase;
import com.example.notes.model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note){
        new Thread(() -> noteDao.insert(note)).start();
    }

    public void delete(Note note){
        new Thread(() -> noteDao.delete(note)).start();
    }

    public void deleteAllNotes(){
        new Thread(() -> noteDao.deleteAllNotes()).start();
    }

    public LiveData<List<Note>> getAllNotes() { //automatically executed in the background thread
        return allNotes;
    }

}
