package com.example.parcial_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contrasenia;
    Button ingresar;

    String us = "Daniel111", pas = "daniel123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.user);
        contrasenia = findViewById(R.id.password);
        ingresar = findViewById(R.id.ingresar);


        //Parseo
        String userString = usuario.getText().toString();
        String passwordString = contrasenia.getText().toString();

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((userString == us) || (passwordString == pas)){
                    Intent intentIngresar = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(intentIngresar);
                }
                else{
                    //Creación del Alert
                    AlertDialog.Builder resultado = new AlertDialog.Builder(MainActivity.this);
                    resultado.setMessage("Usuario o contraseña incorrecta");
                    resultado.setCancelable(false);
                    resultado.setNegativeButton("Intentar de nuevo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog titulo = resultado.create();
                    titulo.setTitle("Inicio de sesión fallido");
                    titulo.show();
                }
            }
        });
    }
}