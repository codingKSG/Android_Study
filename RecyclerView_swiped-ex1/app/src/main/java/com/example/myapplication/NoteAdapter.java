package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{

    private static final String TAG = "NoteAdapter2";
    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void addItem(Note note) {
        notes.add(note);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        notes.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.note_item, parent, false);
        view.setOnClickListener(v -> {
            Log.d(TAG, "onCreateViewHolder: 클릭됨");
            Log.d(TAG, "onCreateViewHolder: ");
        });
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvMin;
        private ImageView ivStar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_title);
            tvSubTitle = itemView.findViewById(R.id.tv_subtitle);
            tvMin = itemView.findViewById(R.id.tv_min);
            ivStar = itemView.findViewById(R.id.iv_star);

            itemView.setOnClickListener(v -> {
                Log.d(TAG, "onCreateViewHolder: " + getAdapterPosition());
                // removeItem(getAdapterPosition());
                addItem(new Note(100, "추가중", "추가중", 123));
            });
        }

        public void setItem(Note note) {
            tvTitle.setText(note.getTitle());
            tvSubTitle.setText(note.getSubTitle());
            tvMin.setText(note.getMin().toString());
        }
    }
}
