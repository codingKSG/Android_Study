package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TalkFragment extends Fragment {

    private static final String TAG = "TalkFragment2";
    private RecyclerView rvTalkList;
    private TalkAdapter talkAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_talk, container, false);

        List<Talk> talks = new ArrayList<>();

        for (int i = 1; i < 11; i++ ){
            talks.add(new Talk(i, "이름"+i, "대화내용"+i, "오후 1시"));
        }

        LinearLayoutManager manager = new LinearLayoutManager(container.getContext(), RecyclerView.VERTICAL, false);
        rvTalkList = view.findViewById(R.id.rv_talk_list);
        rvTalkList.setLayoutManager(manager);

        talkAdapter = new TalkAdapter(talks);

        rvTalkList.setAdapter(talkAdapter);

        return view;
    }
}
