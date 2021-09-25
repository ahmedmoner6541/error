package com.ahmedmoner.mvvm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmedmoner.mvvm.R;
import com.ahmedmoner.mvvm.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.VHolder> {
    private static final String TAG = "NoteAdapter";
    private ArrayList<Note> noteArrayList = new ArrayList<>();
    private Context mContext;


    public NoteAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public VHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VHolder holder, int position) {

        holder.title.setText(noteArrayList.get(position).getTitle());
        holder.discribtion.setText(noteArrayList.get(position).getDisctipiton());

    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }



    public void setList(ArrayList<Note> mList) {
        this.noteArrayList = mList;
        notifyDataSetChanged();
    }

    public Note getpokemonAt(int posation) {
        return noteArrayList.get(posation);
        //يدي بس مهمتها تجيبلك   ال posation اللي ان  فيه
    }


    public class VHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView discribtion;

        public VHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            discribtion = itemView.findViewById(R.id.tv_discribtion);
        }
    }
}