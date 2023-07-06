package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4VerNoticia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_ver_noticia);

        Bundle b = new Bundle();
        b=this.getIntent().getExtras();

        TextView txtTitulo=findViewById(R.id.txtTitulo);
        TextView txtSubtitulo=findViewById(R.id.txtDescripcion);

        txtTitulo.setText(b.getString("Titulo"));
        txtSubtitulo.setText(b.getString("Subtitulo"));
    }
}