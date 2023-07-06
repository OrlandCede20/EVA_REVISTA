package com.example.myapplication.Interfaces;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class iListaAlumnos implements AdapterView.OnItemClickListener {
    Context ctx;

    public iListaAlumnos(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(ctx,"Ha seleccionado el alumno: "+adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_LONG).show();
       // lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {


    }
}
