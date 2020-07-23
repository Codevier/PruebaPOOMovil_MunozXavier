package com.example.pruebapoomovil_munozxavier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mindorks.placeholderview.PlaceHolderView;

public class MainActivity extends AppCompatActivity {

    private PlaceHolderView mGalleryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        mGalleryView
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)))
                .addView(new GalleryItem(getResources().getDrawable(R.drawable.embuandes_opt)));

    }
}