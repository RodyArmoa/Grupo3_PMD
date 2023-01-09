package com.example.grupo3_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    EditText etNombre, etApellidos, etEmail, etContrseña,etContrseña2;
    TextView tvNombre, tvApellidos, tvEmail,tvContraseña, tvContraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = findViewById(R.id.etApellido);
        etApellidos= findViewById(R.id.etApellido);
        etEmail=findViewById(R.id.etEmail);
        etContrseña=findViewById(R.id.etPassword);
        etContrseña2=findViewById(R.id.etPassword2);


        tvNombre =  findViewById(R.id.tvNombre);
        tvApellidos = findViewById(R.id.tvApellido);
        tvEmail = findViewById(R.id.tvEmail);
        tvContraseña = findViewById(R.id.tvContraseña);
        tvContraseña2 = findViewById(R.id.tvContrseña2);
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
        } else if (campo2.isEmpty() ) {
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