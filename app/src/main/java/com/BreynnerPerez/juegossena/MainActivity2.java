package com.BreynnerPerez.juegossena;

import Funciones.ApiRequest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    private EditText searchEditText;
    private RecyclerView recyclerLista;
    Button searchButton;
    ImageButton cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchEditText = findViewById(R.id.searchEditText);
        recyclerLista = findViewById(R.id.recyclerLista);
        searchButton = findViewById(R.id.searchButton);
        cerrar = findViewById(R.id.cerrar);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento= new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intento);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String gameName = searchEditText.getText().toString();
                ApiRequest Peticion= new ApiRequest();
                String response = Peticion.makePost(gameName);

                Log.e("datos2....",response.toString());

               /* try {
                    JSONObject miJsonObj= new JSONObject(response);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }*/

            }
        });
    }
    private void cargarJuegos(int statusCode, String respuesta) throws JSONException {
        if (statusCode == 200){
            // SI hay conexion
            //Log.e("datos", respuesta.toString());
            JSONObject miJsonObj= new JSONObject(respuesta);
            JSONArray miJsonArray = miJsonObj.getJSONArray("data");

            adaptador miAdaptador = new adaptador(this, miJsonArray);
            recyclerLista.setAdapter(miAdaptador);
        }else{
            Toast.makeText(this, ""+respuesta, Toast.LENGTH_SHORT).show();
        }
    }
}