package com.ahmedmoner.mvvm.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ahmedmoner.mvvm.model.Note;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;


@Dao
public interface NoteDao {
    @Insert
    Completable insertNote(Note note);

    @Query("select * from note_table")
    Single<LiveData<List<Note>>> getNotes();


}

