package com.example.myapplication.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Modelos.Usuario;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AdaptadorUsuarios extends ArrayAdapter<Usuario> {
    public AdaptadorUsuarios(Context context, ArrayList<Usuario> datos)
    {
        super(context, R.layout.lyitemusuario, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemusuario, null);

        TextView lblNombres = (TextView)item.findViewById(R.id.lblNombre);
        lblNombres.setText(getItem(position).getNombres());

        TextView lblEmail = (TextView)item.findViewById(R.id.lblEmail);
        lblEmail.setText(getItem(position).getEmail());

        TextView lblWeb = (TextView)item.findViewById(R.id.lblweb);
        lblWeb.setText(getItem(position).getWebsite());


        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);
        Glide.with(this.getContext())
                .load(getItem(position).getUrlavatar()).into(imageView);
        return(item);
    }
}

