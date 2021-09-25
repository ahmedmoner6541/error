package com.ahmedmoner.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahmedmoner.mvvm.model.Note;
import com.ahmedmoner.mvvm.repository.NoteRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class NoteViewModel extends ViewModel {
    private NoteRepository repository  ;



    public NoteViewModel(NoteRepository repository) {
        this.repository = repository;
    }

   public Completable insertNote(Note note){
      return   repository.insertNote(note);
    }
   public void getallNotes(){
       repository.getNotes();
    }

//    public Single<LiveData<List<Note>>>  getallNotes(){
//        return repository.getNotes();
//    }
}
