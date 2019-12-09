package com.example.mytutorials.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytutorials.HeadlinesDetailActivity;
import com.example.mytutorials.Listeners.RecyclerTouchListener;
import com.example.mytutorials.R;
import com.example.mytutorials.SportsDetailActivity;
import com.example.mytutorials.adapters.NewsAdapter;
import com.example.mytutorials.adapters.NewsData;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends Fragment {


    public static List<NewsData> newsDataList;
    NewsAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView headlinesRecycler = (RecyclerView) inflater.inflate(
                R.layout.frag_news, container, false);
        headlinesRecycler.setHasFixedSize(true);
        newsDataList = new ArrayList<>();
        adapter = new NewsAdapter(newsDataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        // horizontal RecyclerView
        // keep content_frag.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        headlinesRecycler.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        headlinesRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        headlinesRecycler.setItemAnimator(new DefaultItemAnimator());
        headlinesRecycler.setAdapter(adapter);
        // row click listener
        headlinesRecycler.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), headlinesRecycler, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                NewsData headline = newsDataList.get(position);
                Toast.makeText(getActivity(), headline.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), SportsDetailActivity.class);
                intent.putExtra(SportsDetailActivity.EXTRA_HEADLINE_ID, position);
                getContext().startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareHeadlinesData();
        return headlinesRecycler;
    }
    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareHeadlinesData() {
        NewsData newsData = new NewsData("Sports_1", R.drawable.sports);
        newsDataList.add(newsData);

        newsData = new NewsData("Sports_2", R.drawable.sports_other);
        newsDataList.add(newsData);
        // notify adapter about data set changes
        // so that it will render the list with new data
        adapter.notifyDataSetChanged();
    }

}
