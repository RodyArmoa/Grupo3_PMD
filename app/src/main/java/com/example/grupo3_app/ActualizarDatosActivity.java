package com.example.grupo3_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.grupo3_app.Networks.ActualizarUser;
import com.example.grupo3_app.Networks.Register;

public class ActualizarDatosActivity extends AppCompatActivity {

    EditText actualizarNombre, actualizarapellidos, actualizarEmail, actualizarPhone, actualizarLocaclidad;
    Button botonGuardar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result != null && result.getResultCode() == RESULT_OK) {


                }
            }
        });

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

                //--Datos que se enviaran a la base de datos---------------//

                if (isConnected()) {
                    ActualizarUser registro = new ActualizarUser(ActualizarDatosActivity.this, ActualizarDatosActivity.this.generateRegisterJson(),ActualizarDatosActivity.this.datosUserb());
                    System.out.println(generateRegisterJson());
                    Thread thread = new Thread(registro);
                    try {
                        thread.start();
                        thread.join(); // Awaiting response from the server...
                    } catch (InterruptedException e) {
                        // Nothing to do here...
                    }
                    // Processing the answer
                    //RegisterResponse registerResponse = registro.getRegisterResponse();
                    Intent intent = new Intent(ActualizarDatosActivity.this, MiPerfilActivity.class);
                    startForResult.launch(intent);
//                        Toast.makeText(RegisterActivity.this, registerResponse.getMensajeRespuesta(), Toast.LENGTH_LONG).show();
                }


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


    public String generateRegisterJson() {
        return "{" +
                "\"email\": \"" + actualizarEmail.getText().toString() + "\", " +
                "\"name\": \"" + actualizarNombre.getText().toString() + "\", " +
                "\"phone\": \"" + actualizarPhone.getText().toString() + "\", " +
                "\"surname\": \"" + actualizarapellidos.getText().toString() + "\"" +
                "}";
    }

    public String datosUserb(){
        Bundle extra= getIntent().getExtras();
        Integer iduser=extra.getInt("userid");
        return "/users/"+iduser;
    }

    public boolean isConnected() {
        boolean ret = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext()
                    .getSystemService( Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if ((networkInfo != null) && (networkInfo.isAvailable()) && (networkInfo.isConnected()))
                ret = true;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), getString(R.string.error_communication), Toast.LENGTH_SHORT).show();
        }
        return ret;
    }
}