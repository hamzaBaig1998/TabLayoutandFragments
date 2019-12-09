package com.example.mytutorials;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.example.mytutorials.adapters.NewsData;
import com.example.mytutorials.fragments.HeadlinesFragment;

public class HeadlinesDetailActivity extends AppCompatActivity {

    public static final String EXTRA_HEADLINE_ID = "headlineId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_headlines);
//Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
//Display details of the pizza
        int headlineId = (Integer)getIntent().getExtras().get(EXTRA_HEADLINE_ID);
        NewsData headline = HeadlinesFragment.newsDataList.get(headlineId);
        String headlineName = headline.getName();
        Toast.makeText(this, headline.getName(), Toast.LENGTH_LONG).show();
        TextView textView = (TextView)findViewById(R.id.headline_text);
        textView.setText(headlineName);
        int headlineImage = headline.getImageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.headline_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, headlineImage));
        imageView.setContentDescription(headlineName);
    }
}
