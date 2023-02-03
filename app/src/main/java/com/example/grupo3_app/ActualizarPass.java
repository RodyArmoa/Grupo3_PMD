package com.example.grupo3_app;

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

import com.example.grupo3_app.Networks.Actualizarpass;
import com.example.grupo3_app.Networks.ResetPass;

public class ActualizarPass extends AppCompatActivity {
    private EditText etemail, etpassv, etpassn, etpassnr;
    private Button btnpass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_pass);
        etemail = findViewById(R.id.correoact);
        etpassv = findViewById(R.id.passwordactual);
        etpassn = findViewById(R.id.passnueva);
        etpassnr = findViewById(R.id.repetirpass);

        btnpass = findViewById(R.id.actualpass);

        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etemail.getText().toString();
                String pass = etpassv.getText().toString();
                String passn = etpassn.getText().toString();
                String passnr = etpassnr.getText().toString();
                System.out.println(generateSongJson());
                if(passn.equals(passnr)){
                    if (isConnected()) {
                        Actualizarpass passNueva = new Actualizarpass(ActualizarPass.this, ActualizarPass.this.generateSongJson(), ActualizarPass.this.datosUserb(email,pass));

                        Thread thread = new Thread(passNueva);
                        try {
                            thread.start();
                            thread.join(); // Awaiting response from the server...
                        } catch (InterruptedException e) {
                            // Nothing to do here...
                        }
                    }
                }
            }
        });
    }

    public String generateSongJson() {

        return "{" +
                "\"password\": \"" + etpassn.getText().toString()  + "\"" +
                "}";
    }

    public String datosUserb(String email,String pass){
        return "/auth/cambiopass/"+email+"/"+pass;
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