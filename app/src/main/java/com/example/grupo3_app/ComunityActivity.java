package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.grupo3_app.Adapter.TeachersAdapter;
import com.example.grupo3_app.Networks.GetTeachers;
import com.example.grupo3_app.Teacher.ListTeacher;
import com.example.grupo3_app.Teacher.Teacher;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ComunityActivity extends AppCompatActivity {
    List<ListTeacher> elementTeacher;
    BottomNavigationView mbottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);
        Bundle extra= getIntent().getExtras();
        Integer iduser=extra.getInt("userid");


        //-----------Barra Menu Inferior---------------------------------------------//

        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_inferior_home) {

                    Intent intent = new Intent(ComunityActivity.this, ComunityActivity.class);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(ComunityActivity.this, "Home", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_favorite) {

                    Intent intent = new Intent(ComunityActivity.this, ActualizarDatosActivity.class);
                    startActivity(intent);
                    Toast.makeText(ComunityActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_perfil) {

                    Intent intent = new Intent(ComunityActivity.this, MiPerfilActivity.class);
                    intent.putExtra("userid",iduser);
                    System.out.println(iduser);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(ComunityActivity.this, "Perfil", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_buscar) {

                    Intent intent = new Intent(ComunityActivity.this, TopicsActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(ComunityActivity.this, "Asignaturas", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });
        //-----------------FIn de Barra Menu inferior------------------//


        //--------Inicializacion del metodo Init()--------//
        ArrayList<Teacher> lista = new ArrayList<>();

        TeachersAdapter teachersAdapter = new TeachersAdapter (this, R.layout.lista_elementos, lista);
        ((ListView) findViewById( R.id.listarecyclerview)).setAdapter (teachersAdapter);





        if (isConnected()) {
            GetTeachers teachers = new GetTeachers();
            Thread thread = new Thread(teachers);
            try {
                thread.start();
                thread.join(); // Awaiting response from the server...
            } catch (InterruptedException e) {
                // Nothing to do here...
            }
            // Processing the answer
            ArrayList<Teacher> listateacher = teachers.getResponse();
            lista.addAll( listateacher );
            ((ListView) findViewById( R.id.listarecyclerview)).setAdapter (teachersAdapter);
        }

    }

    //-----------Menu Item-----------------------------------------------------------//
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(this, "Mi Perfil", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ComunityActivity.this, MiPerfilActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);

        } else if (id == R.id.item2) {
            Toast.makeText(this, "Opiniones", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item3) {

            Intent intent = new Intent(ComunityActivity.this, TopicsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
            Toast.makeText(this, "Asignaturas", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.item4) {
            Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ComunityActivity.this, LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right_in, R.anim.right_out);
        }
        return super.onOptionsItemSelected(item);
    }




    //------------------------Pasar Objetos teacher a Descripcion----------------------------------------------//
    public void moveToDescription(ListTeacher item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListTeacher", item);
        startActivity(intent);

    }

    //------------------------Fin de Pasar Objetos teacher a Descripcion----------------------------------------------//

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