package com.ahmedmoner.mvvm.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String title;
    private String disctipiton;
    //private  int priority ;


    public Note() {
    }

    public Note(String title, String disctipiton) {
        this.title = title;
        this.disctipiton = disctipiton;
    }

    public Note(int id, String title, String disctipiton) {
        this.id = id;
        this.title = title;
        this.disctipiton = disctipiton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDisctipiton() {
        return disctipiton;
    }

    public void setDisctipiton(String disctipiton) {
        this.disctipiton = disctipiton;
    }
}