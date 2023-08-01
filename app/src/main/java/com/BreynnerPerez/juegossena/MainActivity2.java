package com.BreynnerPerez.juegossena;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageButton  cerrar;
    TextView textView;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cerrar=findViewById(R.id.cerrar);
        textView= findViewById(R.id.textView);
        Intent intentoV = getIntent();
        String Usuario = intentoV.getStringExtra("Usuario");
        textView.setText(Usuario);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intento);
            }
        });

    }
}