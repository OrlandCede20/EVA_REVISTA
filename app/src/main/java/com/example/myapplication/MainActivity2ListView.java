package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.Interfaces.iListaAlumnos;

public class MainActivity2ListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_list_view);
        //Datos
        final String[] datos =
                new
                        String[]{"" +
                        "HECTOR MIGUEL CASANOVA MORANTE\n",
                        "ORLANDO JESUS CEDEÑO SALVATIERRA\n",
                        "VALESKA SOFIA CHICA VALFRE\n",
                        "RAUL STEVEN COELLO CASTILLO\n",
                        "DENNYS GREGORIO CONTRERAS SILVA\n",
                        "ANDERSON DAVID JAIME PESANTEZ\n" };
        //Adaptador
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);


        //Vista
        ListView lstOpciones = (ListView)findViewById(R.id.lstLista2);
        lstOpciones.setAdapter(adaptador2);
        lstOpciones.setOnItemClickListener(new iListaAlumnos(this.getApplicationContext()));
    }


}