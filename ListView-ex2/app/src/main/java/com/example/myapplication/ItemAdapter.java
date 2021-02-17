package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

// 1. 컬랙션 정보 2.
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter2";
    private final List<Movie> items;

    public ItemAdapter(List<Movie> items){
        this.items = items;
    }

    // 전체크기를 확인하기 위해서 필요
    @Override
    public int getCount() { // 컬랙션의 사이즈
        return items.size();
    }

    // 클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }
    
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // LayoutInflater inflater = LayoutInflater.from(context);
    // 객체를 생성해서 그림을 그리는 함수
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView: "+position);
        if(convertView == null) {
            Log.d(TAG, "convertView가 null입니다.");
        } else {
            Log.d(TAG, "convertView가 null이 아닙니다.");
        }

        // 1. 부모 컨텍스트 가져오기(Context < MainActivity)
        MainActivity MainActivitycontext = (MainActivity)parent.getContext();

        // 2. 인플레이터 객체 생성 완료(xml을 자바 객체로 만들게 해주는 도구)
        LayoutInflater inflater = (LayoutInflater)MainActivitycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 강제성이 없어서!!
        View view = inflater.inflate(R.layout.list_item ,parent ,false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubTitle = view.findViewById(R.id.tv_subtitle);
        tvTitle.setText(items.get(position).getTitle());
        tvSubTitle.setText(items.get(position).getSubTitle());

        view.setOnClickListener(v -> {
            //Toast.makeText(mainActivitycontext, "클릭됨" + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivitycontext, DetailActivity.class);
            intent.putExtra("title", items.get(position).getTitle());
            MainActivitycontext.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            Toast.makeText(MainActivitycontext, "롱클릭됨" + position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "items 사이즈: " + items.size());
            items.remove(position);
            Log.d(TAG, "items 변경 사이즈: " + items.size());
            this.notifyDataSetChanged();
            return true;
        });

//        if(convertView == null) {
//            convertView = inflater.inflate(R.layout.list_item,parent);
//        }

        return view;
    }
}
