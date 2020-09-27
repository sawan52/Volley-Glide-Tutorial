package com.example.volleyglidetutorial.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.volleyglidetutorial.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        // hide the default action bar
        getSupportActionBar().hide();

        // receive data

        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        String rating = getIntent().getExtras().getString("anime_rating");
        String image_url = getIntent().getExtras().getString("anime_image");


        // init views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitleEnabled(true);


        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_category = findViewById(R.id.aa_category);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView img = findViewById(R.id.aa_thumbnail);


        // set the values to each view

        tv_name.setText(name);
        tv_description.setText(description);
        tv_studio.setText(studio);
        tv_category.setText(category);
        tv_rating.setText(rating);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        // set the image using Glide

        Glide.with(this).load(image_url).apply(requestOptions).into(img);

    }
}
