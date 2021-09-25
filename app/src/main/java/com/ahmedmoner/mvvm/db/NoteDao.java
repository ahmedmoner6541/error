package com.ahmedmoner.mvvm.db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.ahmedmoner.mvvm.model.Note;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;


@Dao
public interface NoteDao {
    @Insert
    Completable insertNote(Note note);

    @Query("select * from note_table")
    Observable<List<Note>> getNotes();
    //Single<LiveData<List<Note>>> getNotes();


}

