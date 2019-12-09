package com.example.mytutorials.adapters;

import android.graphics.drawable.Drawable;
import android.os.health.HealthStats;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytutorials.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<NewsData> newsData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    public NewsAdapter(List<NewsData> newsData){
        this.newsData = newsData;
    }
    @Override
    public int getItemCount(){
        return newsData.size();
    }
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_frag, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable =
                ContextCompat.getDrawable(cardView.getContext(), newsData.get(position).getImageResourceId());
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(newsData.get(position).getName());
        TextView textView = (TextView)cardView.findViewById(R.id.info_text);
        textView.setText(newsData.get(position).getName());
    }
}