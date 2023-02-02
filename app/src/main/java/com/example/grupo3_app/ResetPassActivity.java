package com.example.grupo3_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grupo3_app.Login.Logear;
import com.example.grupo3_app.Networks.Login;
import com.example.grupo3_app.Networks.ResetPass;

public class ResetPassActivity extends AppCompatActivity {
    private Button btnpass;
    private TextView titulo;
    private EditText etemail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);

        btnpass = findViewById(R.id.resetpass);
        titulo = findViewById(R.id.actualizapass);
        etemail = findViewById(R.id.etresetpass);


        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result != null && result.getResultCode() == RESULT_OK) {
                }
            }
        });

        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etemail.getText().toString();
                System.out.println(generateSongJson());
                if(btnpass.getText().equals(getString(R.string.btn_reset))){
                    btnpass.setText(R.string.btn_volver);
                    titulo.setText(R.string.pass_cambiada);
                    if (isConnected()) {
                        ResetPass reset = new ResetPass(ResetPassActivity.this, ResetPassActivity.this.generateSongJson(), ResetPassActivity.this.datosUserb(email));

                        Thread thread = new Thread(reset);
                        try {
                            System.out.println("hola");

                            thread.start();
                            thread.join(); // Awaiting response from the server...
                        } catch (InterruptedException e) {
                            // Nothing to do here...
                        }

                    }
                }
                else{
                    Intent intent = new Intent(ResetPassActivity.this, LoginActivity.class);
                    startForResult.launch(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);
                    finish();
                }
            }
        });

    }

    public String generateSongJson() {

        return "{" +
                "\"email\": \"" + etemail.getText().toString()  + "\"" +
                "}";
    }

    public String datosUserb(String email){
        return "/auth/enviarEmail/"+email;
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
