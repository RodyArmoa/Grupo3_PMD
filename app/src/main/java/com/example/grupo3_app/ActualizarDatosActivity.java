package com.example.grupo3_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActualizarDatosActivity extends AppCompatActivity {

    EditText actualizarNombre, actualizarapellidos, actualizarEmail, actualizarPhone, actualizarLocaclidad;
    Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actualizar_datos);
        actualizarNombre = (EditText) findViewById(R.id.actualizarNombre);
        actualizarapellidos = (EditText) findViewById(R.id.actualizarapellidos);
        actualizarEmail = (EditText) findViewById(R.id.actualizarEmail);
        actualizarPhone = (EditText) findViewById(R.id.actualizarPhone);
        actualizarLocaclidad = (EditText) findViewById(R.id.actualizarLocaclidad);
        botonGuardar = (Button) findViewById(R.id.botonGuardar);


        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //        CREAR FUNCION PARA ACTUALIZAR DATOS DE USUARIO



                Bundle enviar1 = new Bundle();
                Bundle enviar2 = new Bundle();
                Bundle enviar3 = new Bundle();
                Bundle enviar4 = new Bundle();
                Bundle enviar5 = new Bundle();
                enviar1.putString("keyDatos1", actualizarNombre.getText().toString());
                enviar2.putString("keyDatos2", actualizarapellidos.getText().toString());
                enviar3.putString("keyDatos3", actualizarEmail.getText().toString());
                enviar4.putString("keyDatos4", actualizarPhone.getText().toString());
                enviar5.putString("keyDatos5", actualizarLocaclidad.getText().toString());
                Intent intent = new Intent(ActualizarDatosActivity.this, MiPerfilActivity.class);
                intent.putExtras(enviar1);
                intent.putExtras(enviar2);
                intent.putExtras(enviar3);
                intent.putExtras(enviar4);
                intent.putExtras(enviar5);

                //----Pasamos un valor booleano TRUE a MiPerfilActivity-----//
                intent.putExtra("isTrue", true);

                startActivity(intent);
            }
        });

    }
}