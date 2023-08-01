package com.BreynnerPerez.juegossena;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnIngresar, btnRegistar;
    EditText editUsuario, editContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUsuario = findViewById(R.id.editUsuario);
        editContraseña = findViewById(R.id.editContraseña);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editUsuario.getText().toString();
                String contraseña = editContraseña.getText().toString();

                if (TextUtils.isEmpty(usuario) || TextUtils.isEmpty(contraseña)) {
                    // Si algún campo está vacío, muestra un mensaje de error
                    editUsuario.setError("Debes ingresar un Usuario ");
                    editContraseña.setError("Debes ingresar una Contraseña");
                    Toast.makeText(MainActivity.this, "Ingresa el usuario y la contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    // Ambos campos tienen datos, continuar con el inicio de sesión
                    Intent intento = new Intent(MainActivity.this, MainActivity2.class);
                    intento.putExtra("Usuario", usuario);
                    startActivity(intento);
                }
            }
        });

        btnRegistar = findViewById(R.id.btnRegistrar);
        btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(MainActivity.this, Registro.class);
                startActivity(intento);
            }
        });
    }
}