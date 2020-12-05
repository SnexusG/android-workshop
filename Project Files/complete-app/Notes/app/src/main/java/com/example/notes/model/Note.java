package com.example.notes.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note-table") //if table name not specified by default it is name of the class
public class Note {
    //components of the table
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title_column")
    private String title;
    @ColumnInfo(name = "description column")
    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
