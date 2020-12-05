package com.example.notes.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.notes.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM `note-table`")
    void deleteAllNotes();

    @Query("SELECT * FROM `note-table`")
    LiveData<List<Note>> getAllNotes();
}
