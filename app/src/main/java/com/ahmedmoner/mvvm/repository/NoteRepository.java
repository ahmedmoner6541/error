package com.ahmedmoner.mvvm.repository;

import com.ahmedmoner.mvvm.db.NoteDao;
import com.ahmedmoner.mvvm.model.Note;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class NoteRepository {
    private NoteDao noteDao;

    public NoteRepository(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public Completable insertNote(Note note){
       return noteDao.insertNote(note);
    }

    public Observable<List<Note>> getNotes(){
        return noteDao.getNotes();
    }
}
