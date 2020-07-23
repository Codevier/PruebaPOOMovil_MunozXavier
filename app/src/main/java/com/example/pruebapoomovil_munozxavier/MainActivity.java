package com.example.pruebapoomovil_munozxavier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.example.pruebapoomovil_munozxavier.WebService.Asynchtask;
import com.example.pruebapoomovil_munozxavier.WebService.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    private PlaceHolderView mGalleryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://api.jsonbin.io/b/5efe857d0bab551d2b6af8b1",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
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
        //mGalleryView.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(), 2));
    }

    @Override
    public void processFinish(String result) throws JSONException {

    }
}