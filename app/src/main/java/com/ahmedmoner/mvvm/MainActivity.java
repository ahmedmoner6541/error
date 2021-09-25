package com.ahmedmoner.mvvm;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmedmoner.mvvm.adapters.NoteAdapter;
import com.ahmedmoner.mvvm.databinding.ActivityMainBinding;
import com.ahmedmoner.mvvm.model.Note;
import com.ahmedmoner.mvvm.viewmodels.NoteViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;
    private NoteViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);

//        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        noteAdapter = new NoteAdapter(this);
        recyclerView.setAdapter(noteAdapter);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.insertNote(new Note(binding.etTitle.getText().toString(), binding.etDisc.getText().toString()))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });

            }

        });

        binding.getall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                viewModel.getallNotes()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<List<Note>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@NonNull List<Note> notes) {
                                ArrayList<Note> list = new ArrayList<>();
                                list.addAll(notes);//حول من لستت لاراي ليست
                                noteAdapter.setList(list);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

            }
        });
    }
}