package com.example.myapplication;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// 익명클래스 내부에서는 외부의 변수(스택)에 접근할 수 있지만 변경은 불가능하다.
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private static final String TAG = "MovieAdapter2";
    private final List<Integer> movies;
    private float saveRating = 0;

    public MovieAdapter(List<Integer> movies) {
        this.movies = movies;
    }

    public void addItem(Integer position) {
        movies.add(position);
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        movies.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.movie_item, parent, false);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPost;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPost = itemView.findViewById(R.id.iv_post);

            // ViewGroup 정보 또는 Activity 정보
            ivPost.setOnClickListener(v -> {
                View dialog = v.inflate(v.getContext(), R.layout.dialog_item, null);
                ImageView ivItem = dialog.findViewById(R.id.iv_item);
                int pos = getAdapterPosition();
                ivItem.setImageResource(movies.get(pos));
                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());

                // 추가
                SharedPreferences pref = v.getContext().getSharedPreferences("pref", MainActivity.MODE_PRIVATE);

                RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
                TextView tvRating = dialog.findViewById(R.id.rating);
                ratingBar.setRating(pref.getFloat("rating"+pos, 0));
                tvRating.setText(pref.getFloat("rating"+pos, 0)+"");

                ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
                    Log.d(TAG, "MyViewHolder: rating - "+ rating);
                    tvRating.setText(rating+"");
                    saveRating = rating;
                });

                dlg.setTitle("큰 포스터");
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView(dialog);
                dlg.setNegativeButton("닫기", null);
                dlg.setPositiveButton("확인", (dialog1, which) ->{
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putFloat("rating"+pos, saveRating);
                    ed.commit();
                });
                dlg.show();
            });
        }

        public void setItem(Integer imgNum){
            ivPost.setImageResource(imgNum);
        }
    }
}
