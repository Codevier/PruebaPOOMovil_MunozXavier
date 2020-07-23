package com.example.pruebapoomovil_munozxavier.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewempleos.Model.Carpeta;
import com.example.recyclerviewempleos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorCarpeta extends RecyclerView.Adapter<AdaptadorCarpeta.ViewHolder> {
    ArrayList<Carpeta> listaCarpetas;

    public AdaptadorCarpeta(ArrayList<Carpeta> listaCarpetas) {
        this.listaCarpetas = listaCarpetas;
    }


    @NonNull
    @Override
    public AdaptadorCarpeta.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.ly_item_carpeta, null);
        return new AdaptadorCarpeta.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorCarpeta.ViewHolder holder, int position) {
        holder.title.setText(listaCarpetas.get(position).getTitle());
        holder.item.setText(listaCarpetas.get(position).getItem());
        holder.date.setText(listaCarpetas.get(position).getDate());
        holder.hour.setText(listaCarpetas.get(position).getHour());
        Picasso.get().load(listaCarpetas.get(position).getImg()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listaCarpetas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, item, date, hour;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.lbltitle);
            item=(TextView) itemView.findViewById(R.id.lblitem);
            date= (TextView) itemView.findViewById(R.id.lbldate);
            hour=(TextView) itemView.findViewById(R.id.lblhour);
            imageView = (ImageView)itemView.findViewById(R.id.imgCarp);
        }
    }
}
