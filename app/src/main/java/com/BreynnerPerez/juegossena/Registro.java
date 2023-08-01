package com.BreynnerPerez.juegossena;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    Button btnRegistro;
    EditText editIngrese, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro= findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Registro.this,MainActivity.class);
                startActivity(intento);
            }
        });
        editIngrese= findViewById(R.id.editIngrese);
        editPassword= findViewById(R.id.editPassword);
    }
}