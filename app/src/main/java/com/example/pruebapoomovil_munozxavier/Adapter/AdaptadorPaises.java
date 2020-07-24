package com.example.pruebapoomovil_munozxavier.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebapoomovil_munozxavier.Model.Paises;
import com.example.pruebapoomovil_munozxavier.R;
import com.mindorks.placeholderview.PlaceHolderView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPaises extends PlaceHolderView.Adapter<AdaptadorPaises.ViewHolder> {

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
        String url="http://www.geognos.com/api/en/countries/flag/"+listPaises.get(position).getAlpha2Code()+".png";
        Picasso.get().load(url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return  listPaises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //TextView name;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
