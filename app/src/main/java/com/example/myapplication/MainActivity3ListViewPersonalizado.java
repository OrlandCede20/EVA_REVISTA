package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.myapplication.Adaptadores.AdaptadorNoticias;
import com.example.myapplication.Interfaces.iListaAlumnos;
import com.example.myapplication.Modelos.Noticia;

public class MainActivity3ListViewPersonalizado extends AppCompatActivity
    implements AdapterView.OnItemClickListener{
    public Noticia[] noticias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_list_view_personalizado);

        //Noticia
        noticias = new Noticia[]{
                        new Noticia("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
                        new Noticia("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
                        new Noticia("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
                        new Noticia("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4"),
                        new Noticia("Noticia 5", "SubNoticia Contenido Contenido Contenido Contenido 5"),
                        new Noticia("Noticia 5", "SubNoticia Contenido Contenido Contenido Contenido 6")};

        //Adaptador
        AdaptadorNoticias adaptadorNoticias = new AdaptadorNoticias(this,noticias);

        //Vista
        ListView lstOpciones = (ListView)findViewById(R.id.lstLista2);

        View header = getLayoutInflater().inflate(R.layout.lyheader, null);
        lstOpciones.addHeaderView(header);

        lstOpciones.setAdapter(adaptadorNoticias);
        //lstOpciones.setOnItemClickListener(new iListaAlumnos(this.getApplicationContext()));
        lstOpciones.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(MainActivity3ListViewPersonalizado.this, MainActivity4VerNoticia.class);
        Noticia noticia = (Noticia)adapterView.getItemAtPosition(i);
        Bundle b = new Bundle();
        b.putString("Titulo", noticia.getTitulo());
        b.putString("Subtitulo",noticia.getSubtitulo());
        intent.putExtras(b);
        startActivity(intent);

    }
}