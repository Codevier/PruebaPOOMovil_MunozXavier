package com.example.pruebapoomovil_munozxavier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pruebapoomovil_munozxavier.Adapter.AdaptadorPaises;
import com.example.pruebapoomovil_munozxavier.Model.Paises;
import com.example.pruebapoomovil_munozxavier.WebService.Asynchtask;
import com.example.pruebapoomovil_munozxavier.WebService.WebService;
//import com.mindorks.placeholderview.PlaceHolderView;
//import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {


    //private PlaceHolderView mGalleryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

        /*

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
                */
        //mGalleryView.getBuilder().setLayoutManager(new GridLayoutManager(this.getApplicationContext(), 2));
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Paises> lstPaises = new ArrayList<Paises> ();
        JSONArray JSONlista =  new JSONArray(result);
        lstPaises=Paises.JsonObjectsBuild(JSONlista);
        //mGalleryView = (PlaceHolderView)findViewById(R.id.galleryView);
        RecyclerView placeHolderView;
        placeHolderView=(RecyclerView) findViewById(R.id.galleryView);
        placeHolderView.setLayoutManager(new LinearLayoutManager(this));
        AdaptadorPaises adaptadorPaises= new AdaptadorPaises(lstPaises);
        placeHolderView.setAdapter(adaptadorPaises);

        /*
        for(int i = 0; i< JSONlista.length(); i++){
            JSONObject pais=  JSONlista.getJSONObject(i);

            //lstBancos= lstBancos +"\n" +pais.getString("name").toString();
            mGalleryView.addView(new GalleryItem(pais.getString("alpha2Code")));
        }
        */

        /*
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
                */
        //txtBancos.setText("Respuesta WS: " + lstBancos);
        //txtBancos.setText("Respuesta WS: " + result);
        //bundle.getString("NOMBRE")+ "\n CLAVE:"+bundle.getString("PASS"));

    }
}