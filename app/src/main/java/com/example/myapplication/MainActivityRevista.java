package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Adaptadores.AdaptadorRevista;
import com.example.myapplication.Adaptadores.AdaptadorUsuarios;
import com.example.myapplication.Modelos.Revista;
import com.example.myapplication.Modelos.Usuario;
import com.example.myapplication.WebServices.Asynchtask;
import com.example.myapplication.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivityRevista extends AppCompatActivity
        implements Asynchtask {
    ImageView port;
    TextView txtNomr;
    ListView lstOpciones;
    ArrayList<Revista> lstRevista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyrevista_item);
        port = (ImageView)findViewById(R.id.imgportada);
        txtNomr =(TextView)findViewById(R.id.txtnombrerevista);

        View header = getLayoutInflater().inflate(R.layout.lyrevista_item, null);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivityRevista.this   , MainActivityRevista.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista = new JSONObject(result);
        JSONArray JSONlistaRevista= JSONlista.getJSONArray("data");
        lstRevista = Revista.JsonObjectsBuild(JSONlistaRevista);
        AdaptadorRevista adapatorRevista = new AdaptadorRevista(this, lstRevista);
        lstOpciones.setAdapter(adapatorRevista);
    }
}
