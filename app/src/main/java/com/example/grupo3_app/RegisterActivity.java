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
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupo3_app.Networks.Register;
import com.example.grupo3_app.Response.RegisterResponse;

public class RegisterActivity extends AppCompatActivity {

    EditText etNombre, etApellidos, etEmail, etContrseña, etContrseña2, etPhone;
    TextView tvNombre, tvApellidos, tvEmail, tvContraseña, tvContraseña2;
    Button btnRegistrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellido);
        etEmail = findViewById(R.id.etEmail);
        etContrseña = findViewById(R.id.etPassword);
        etContrseña2 = findViewById(R.id.etPassword2);
        etPhone = findViewById(R.id.etPhone);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result != null && result.getResultCode() == RESULT_OK) {


                }
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( validarRegistro() ){

                    if (isConnected()) {
                        Register registro = new Register(RegisterActivity.this, RegisterActivity.this.generateRegisterJson());
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
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startForResult.launch(intent);
//                        Toast.makeText(RegisterActivity.this, registerResponse.getMensajeRespuesta(), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }

    public String generateRegisterJson() {
        return "{" +
                "\"email\": \"" + etEmail.getText().toString() + "\", " +
                "\"name\": \"" + etNombre.getText().toString() + "\", " +
                "\"phone\": \"" + etPhone.getText().toString() + "\", " +
                "\"surname\": \"" + etApellidos.getText().toString() + "\", " +
                "\"password\": \"" + etContrseña.getText().toString() + "\" " +
                "}";
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


    public boolean validarRegistro() {

        boolean retorno = true;


        String campo1 = etNombre.getText().toString();
        String campo2 = etApellidos.getText().toString();
        String campo3 = etEmail.getText().toString();
        String campo4 = etContrseña.getText().toString();
        String campo5 = etContrseña2.getText().toString();


        if (campo1.isEmpty()) {
            etNombre.setError("Nombre no introducido");
            retorno = false;
        } else if (campo2.isEmpty()) {
            etApellidos.setError("Apellidos no Introducido");

            retorno = false;
        } else if (campo3.isEmpty()) {
            etEmail.setError("Email no introducido");
            retorno = false;

        } else if (campo4.isEmpty()) {
            etContrseña.setError("Primera Passsword no introducido");
            retorno = false;
            return retorno;
        } else if (campo5.isEmpty()) {
            etContrseña2.setError("Segunda Passsword no introducido");
            retorno = false;
        }
        if (!campo4.equals(campo5)) {
            etContrseña2.setError("La segunda contraseña no coincide");
            retorno = false;
        }
        return retorno;


    }
}