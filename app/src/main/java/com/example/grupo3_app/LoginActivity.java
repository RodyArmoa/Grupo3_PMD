package com.example.grupo3_app;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etNombre, etpassword;
    private Button btnEntrar, btnRegistrar;
    private CheckBox checkBox;
    private boolean existeUsuario = false;
    private SharedPreferences mPrefs;

    private int attemps = 0;

    private static final String PREF_NAME = "prefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mPrefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);


        bindWidget();
        resizeIcons();
        setupWidgetEventListener();
        getPreferencesData();


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

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startForResult.launch(intent);
                overridePendingTransition(R.anim.right_in, R.anim.right_out);

                finish();

            }
        });


    }

    private void resizeIcons() {

        final float destiny = getResources().getDisplayMetrics().density;

    }

    private void getPreferencesData() {

        SharedPreferences sp = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        if (sp.contains("pref_name")) {
            String u = sp.getString("pref_name", "No hay usuario guardado");
            etNombre.setText(u.toString());

        }
        if (sp.contains("pref_pass")) {
            String p = sp.getString("pref_pass", "No password");
            etpassword.setText(p.toString());
        }
        if (sp.contains("pref_check")) {

            Boolean b = sp.getBoolean("pref_check", false);
            checkBox.setChecked(b);
        }
    }

    private void bindWidget() {


        etNombre = findViewById(R.id.textViewLogin);
        etpassword = findViewById(R.id.insert_pass);
        checkBox = findViewById(R.id.recordar);

        btnEntrar = findViewById(R.id.btn_entrar);
        btnRegistrar = findViewById(R.id.btn_registra);
    }

    private void setupWidgetEventListener() {


        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result != null && result.getResultCode() == RESULT_OK) {


                }
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //attemps++;

                if ((!etNombre.getText().toString().equals("")) && (!etpassword.getText().toString().equals(""))) {

                    if ((!etNombre.getText().toString().equals("Rodrigo"))
                            && (!etpassword.getText().toString().equals("123456"))) {


                        if (checkBox.isChecked()) {
                            Boolean boolIsChecked = checkBox.isChecked();
                            SharedPreferences.Editor editor = mPrefs.edit();
                            editor.putString("pref_name", etNombre.getText().toString());
                            editor.putString("pref_pass", etpassword.getText().toString());
                            editor.putBoolean("pref_check", boolIsChecked);
                            editor.apply();
                            Toast.makeText(getApplicationContext(), "Se ha guardado",
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            mPrefs.edit().clear().apply();

                        }

                        Log.i("Username", etNombre.getText().toString());
                        Log.i("Password", etpassword.getText().toString());

                        Context context = getApplicationContext();
                        String string = "Username: " + etNombre.getText().toString()
                                + "\nPassword: " + etpassword.getText().toString();

                        int duartion = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, string, duartion);
                        Intent intent = new Intent(LoginActivity.this, ComunityActivity.class);
                        startForResult.launch(intent);
                        overridePendingTransition(R.anim.zoom_back_in, R.anim.zoom_back_out);

                        // Intent intent = new Intent(getBaseContext(), ComunityActivity.class);
                        //intent.putExtra("ux",etNombre.getText().toString());
                        //startActivity(intent);


                        etNombre.getText().clear();
                        etpassword.getText().clear();


                    }


                }
            }
        });
    }

    public boolean validarLogin() {

        boolean retorno = true;

        String campo1 = etNombre.getText().toString();
        String campo2 = etpassword.getText().toString();

        if (campo1.isEmpty()) {
            etNombre.setError("Login no introducido");
            Toast.makeText(this, "Login no introducido", Toast.LENGTH_SHORT).show();
            retorno = false;
        }
        if (campo2.isEmpty()) {
            etpassword.setError("Password no introducido");
            retorno = false;
        }
        return retorno;
    }


}
