package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.myapplication.Adaptadores.AdaptadorUsuarios;
import com.example.myapplication.Modelos.Usuario;
import com.example.myapplication.WebServices.Asynchtask;
import com.example.myapplication.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity5WebServices extends AppCompatActivity
implements Asynchtask {
    ListView lstOpciones;
    ArrayList<Usuario> lstUsuarioss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_web_services);

        lstOpciones = (ListView)findViewById(R.id.lstUsuarios);
        View header = getLayoutInflater().inflate(R.layout.lyheaderlu, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users",
                datos, MainActivity5WebServices.this   , MainActivity5WebServices.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("data");
        lstUsuarioss = Usuario.JsonObjectsBuild(JSONlistaUsuarios);
        AdaptadorUsuarios adapatorUsuario = new AdaptadorUsuarios(this, lstUsuarioss);
        lstOpciones.setAdapter(adapatorUsuario);

    }
}