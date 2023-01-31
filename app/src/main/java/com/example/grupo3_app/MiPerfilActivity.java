package com.example.grupo3_app;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MiPerfilActivity extends AppCompatActivity {

    TextView idNombreDatos, idApellidosDatos, idEmailDatos, idPhoneDato, idLocationDato;
    Button idBtnActualizarDato;
    ImageButton botonImagnPerfil;
    private ImageView selectedImageView;
    private Uri selectedImageUri;
    boolean actualizado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);

      //---creamos una ImageButton para acederr a la galeria local y cambiar la foto del perfil
        selectedImageView= (ImageView)findViewById(R.id.idImagenDatos);
        botonImagnPerfil= findViewById(R.id.select_image_button);

        botonImagnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        //-------Solo entraria en esta funcion funcion si pasamos un valor Boolean desde ActualizarDatosActivity--//

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

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }


    //-------Metodo para acceder a la galeria del usuario
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.getData();
            selectedImageView.setImageURI(selectedImageUri);
        }
    }

    private static final int PICK_IMAGE_REQUEST = 1;



}