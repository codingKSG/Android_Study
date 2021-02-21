package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.MyViewHolder> {

    private static final String TAG = "TalkAdapter2";
    private final List<Talk> talks;

    public TalkAdapter(List<Talk> talks) {
        this.talks = talks;
    }

    public void addItem(Talk talk) {
        talks.add(talk);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        talks.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.talk_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(talks.get(position));
    }

    @Override
    public int getItemCount() {
        return talks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTalkName;
        private TextView tvcontent;
        private TextView tvupdateTime;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTalkName = itemView.findViewById(R.id.tv_talk_name);
            tvcontent = itemView.findViewById(R.id.tv_content);
            tvupdateTime = itemView.findViewById(R.id.tv_update_time);
        }

        public void setItem(Talk talk) {
            tvTalkName.setText(talk.getTalkName());
            tvcontent.setText(talk.getContent());
            tvupdateTime.setText(talk.getUpdateTime());
        }
    }
}
