package com.example.grupo3_app;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupo3_app.Response.UserResponse;
import com.example.grupo3_app.User.User;

public class MiPerfilActivity extends AppCompatActivity {

    TextView idNombreDatos, idApellidosDatos, idEmailDatos, idPhoneDato, idLocationDato;
    Button idBtnActualizarDato;
    boolean actualizado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);
        Bundle extra= getIntent().getExtras();
        Integer iduser=extra.getInt("userid");

        //--Solo entraria en esta funcion funcion si pasamos un valor Boolean desde ActualizarDatosActivity--//

        Boolean isTrue = getIntent().getBooleanExtra("isTrue", false);

        if (isTrue) {
            idNombreDatos = (TextView) findViewById(R.id.idNombreDatos);
            idApellidosDatos = (TextView) findViewById(R.id.idApellidosDatos);
            idEmailDatos = (TextView) findViewById(R.id.idEmailDatos);
            idPhoneDato = (TextView) findViewById(R.id.idPhoneDato);
            idLocationDato = (TextView) findViewById(R.id.idLocationDato);


            Bundle recibirDatos1 = getIntent().getExtras();
            String info1 = recibirDatos1.getString("keyDatos1");

            Bundle recibirDatos2 = getIntent().getExtras();
            String info2 = recibirDatos2.getString("keyDatos2");

            Bundle recibirDatos3 = getIntent().getExtras();
            String info3 = recibirDatos3.getString("keyDatos3");

            Bundle recibirDatos4 = getIntent().getExtras();
            String info4 = recibirDatos4.getString("keyDatos4");

            Bundle recibirDatos5 = getIntent().getExtras();
            String info5 = recibirDatos5.getString("keyDatos5");
            idNombreDatos.setText(info1);
            idApellidosDatos.setText(info2);
            idEmailDatos.setText(info3);
            idPhoneDato.setText(info4);
            idLocationDato.setText(info5);


        }




        //        CREAR FUNCION PARA LLAMAR DATOS DE USUARIO




        idBtnActualizarDato = (Button) findViewById(R.id.idBtnActualizarDato);

        idBtnActualizarDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MiPerfilActivity.this, ActualizarDatosActivity.class);
                intent.putExtra("userid",iduser);
                System.out.println(iduser);
                startActivity(intent);

            }
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Mis Datos");
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public boolean onSupportNavigateUp() {

        onBackPressed();

        return super.onSupportNavigateUp();
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