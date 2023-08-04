package com.BreynnerPerez.juegossena;

import Funciones.ApiRequest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity2 extends AppCompatActivity {
    private EditText searchEditText;
    private RecyclerView resultTextView;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        searchEditText = findViewById(R.id.searchEditText);
        resultTextView = findViewById(R.id.Recycleresult);
        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String gameName = searchEditText.getText().toString();
                ApiRequest Peticion= new ApiRequest();
                Peticion.makePost(gameName);

            }
        });
    }
}


