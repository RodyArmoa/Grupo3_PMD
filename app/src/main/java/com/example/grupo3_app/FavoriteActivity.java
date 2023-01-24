package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.grupo3_app.Teacher.ListTeacher;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity {
    List<ListTeacher> elementTeacher;
    BottomNavigationView mbottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);




        //-----------Barra Menu Inferior---------------------------------------------//

        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_inferior_home) {

                    Intent intent = new Intent(FavoriteActivity.this, FavoriteActivity.class);
                    startActivity(intent);
                    //overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(FavoriteActivity.this, "Home", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_favorite) {

                    Intent intent = new Intent(FavoriteActivity.this, ActualizarDatosActivity.class);
                    startActivity(intent);
                    Toast.makeText(FavoriteActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_perfil) {

                    Intent intent = new Intent(FavoriteActivity.this, MiPerfilActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(FavoriteActivity.this, "Perfil", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_buscar) {

                    Intent intent = new Intent(FavoriteActivity.this, TopicsActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(FavoriteActivity.this, "Asignaturas", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });
        //-----------------FIn de Barra Menu inferior------------------//
    }
    //------------------------Pasar Objetos teacher a Descripcion----------------------------------------------//
    public void moveToDescription(ListTeacher item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListTeacher", item);
        startActivity(intent);

    }

    //------------------------Fin de Pasar Objetos teacher a Descripcion----------------------------------------------//
}