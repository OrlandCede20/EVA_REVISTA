package com.example.myapplication.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Modelos.Revista;
import com.example.myapplication.R;

import java.util.ArrayList;


public class AdaptadorRevista extends ArrayAdapter<Revista> {
    public AdaptadorRevista(Context context, ArrayList<Revista> datos)
    {
        super(context, R.layout.lyrevista_item);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyrevista_item, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.txtnombrerevista);
        lblTitulo.setText(getItem(position).getTitulo());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgportada);
        Glide.with(this.getContext())
                .load(getItem(position).getJournal_id()).into(imageView);
        return(item);
    }
}
