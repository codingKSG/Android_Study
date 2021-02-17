package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private static final String TAG = "MovieAdapter2";
    private final List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void addItem(Movie movie) {
        movies.add(movie);
        notifyDataSetChanged();
    }

    public void uiChange() {
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        movies.remove(position);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MainActivity mainActivityContext = (MainActivity)parent.getContext();
        LayoutInflater inflater = (LayoutInflater) mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.grid_item, parent, false);
        ImageView ivMovie = convertView.findViewById(R.id.iv_movie);
        TextView tvMovTitle = convertView.findViewById(R.id.tv_movtitle);
        ivMovie.setImageResource(movies.get(position).getPic());
        tvMovTitle.setText(movies.get(position).getTitle());

        convertView.setOnClickListener(v -> {
            //Toast.makeText(mainActivitycontext, "클릭됨" + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mainActivityContext, DetailActivity.class);
            intent.putExtra("title", movies.get(position).getTitle());
            mainActivityContext.startActivity(intent);
        });

        convertView.setOnLongClickListener(v -> {
            Toast.makeText(mainActivityContext, "롱클릭됨" + position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "items 사이즈: " + movies.size());
            movies.remove(position);
            Log.d(TAG, "items 변경 사이즈: " + movies.size());
            this.notifyDataSetChanged();
            return true;
        });

        return convertView;
    }
}
