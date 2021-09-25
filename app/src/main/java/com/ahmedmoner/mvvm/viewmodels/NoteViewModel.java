package com.ahmedmoner.mvvm.viewmodels;

import androidx.lifecycle.ViewModel;

import com.ahmedmoner.mvvm.model.Note;
import com.ahmedmoner.mvvm.repository.NoteRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class NoteViewModel extends ViewModel {

    private NoteRepository repository;


    public NoteViewModel(NoteRepository repository) {
        this.repository = repository;
    }


    public Completable insertNote(Note note) {
        return repository.insertNote(note);
    }



    public Observable<List<Note>> getallNotes(){
        return repository.getNotes();
    }
}
