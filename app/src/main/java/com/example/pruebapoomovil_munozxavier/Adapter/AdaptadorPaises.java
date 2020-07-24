package com.example.pruebapoomovil_munozxavier.Adapter;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.example.pruebapoomovil_munozxavier.Model.Paises;
import com.example.pruebapoomovil_munozxavier.R;
//import com.mindorks.placeholderview.PlaceHolderView;
//import com.mindorks.placeholderview.PlaceHolderView;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AdaptadorPaises extends RecyclerView.Adapter<AdaptadorPaises.ViewHolder> {

    ArrayList<Paises> listPaises;

    public AdaptadorPaises(ArrayList<Paises> listPaises) {
        this.listPaises = listPaises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.gallery_item, null);
        return new AdaptadorPaises.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(listPaises.get(position).getName());
        String url = "http://www.geognos.com/api/en/countries/flag/"+ listPaises.get(position).getAlpha2Code().toString()+".png" ;
        Picasso.get().load(url).into(holder.imageView);
        //Glide.with(mcontext)
          //      .load(url)
            //    .into(holder.imageView);
        //Picasso.get().load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return  listPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.lblTittle);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
