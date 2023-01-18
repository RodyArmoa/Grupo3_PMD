package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.grupo3_app.Teacher.ListAdapter;
import com.example.grupo3_app.Teacher.ListTeacher;
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


        //-----------Barra Menu Inferior---------------------------------------------//

        mbottomNavigationView = (BottomNavigationView)findViewById(R.id.bottonNavigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.menu_inferior_home){

                    Toast.makeText(ComunityActivity.this, "Home", Toast.LENGTH_SHORT).show();

                } if (item.getItemId()==R.id.menu_inferior_favorite){


                    Toast.makeText(ComunityActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();

                } if (item.getItemId()==R.id.menu_inferior_perfil){

                    Intent intent = new Intent(ComunityActivity.this, MiPerfilActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(ComunityActivity.this, "Perfil", Toast.LENGTH_SHORT).show();

                }


                return true;
            }
        });
        //-----------------FIn de Barra Menu inferior------------------//


        //--------Inicializacion del metodo Init()--------//
        init();

        //--------Fin del Inicializacion del metodo Init()--------//

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

        }
        return super.onOptionsItemSelected(item);
    }


    //-----------Recyclerview teacher Listas-----------------------------------------------------------//
    //----------Esta lista lo realizamos de manera provicional, es simplemente
    // un ejemplo para comprobar los layout correspondientes-----------------------//

    public void init() {

        elementTeacher = new ArrayList<>();
        elementTeacher.add(new ListTeacher("#775447", "José Mourinho", "Diseño Interfaces", "Bilbao", "Ingeniero te apoya en tareas , exámenes y clases online. Soy experto en programación UNI, con más de 15 años de experiencia. dirigido a estudiantes de Sistemas.\n" +
                "Cientos de alumnos nacionales y extranjeros garantizan mi servicio."));
        elementTeacher.add(new ListTeacher("#76D7C4", "Aitana", "Programacion Web", "Vitoria", "Es una profesora increible, " +
                "ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#717D7E", "Rocio", "Programacion Python", "Bilbao", "Me llamo Rocío, soy Ingeniera en Informática graduada por la universidad de Granada y siempre me ha gustado compartir mi pasión por la programación.\n" +
                "Me gusta compartir mi motivación con los estudiantes en un ambiente relajado, donde puedan hacer cualquier tipo de preguntas y haciendo ejercicios divertidos.\n" +
                "Me encanta enseñar a programar, especialmente en Python!"));
        elementTeacher.add(new ListTeacher("#76448A", "Iñaki", "Programacion Web", "Vitoria", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#633974", "Jon", "Programacion Web", "Bilbao", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#0B5345", "Mikel", "Microsoft Azure ", "Donosti", "Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#D68910", "Joseba", "Machine learning ", "Vitoria", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#BA4A00", "Asier", "Acceso a Datos", "Bilbao", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#922B21", "Borja", "Big Data Analytics", "Ausente", "Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#775447", "Aitxiber", "Lenguaje de marcas", "Donosti", "Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#775447", "Rodrigo", "Sistemas Informaticos", "Donosti", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#76D7C4", "Asier", "Programacion .NET", "Vitoria", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#717D7E", "David", "Entorno de Desarrollo", "Donosti", "Es una profesora increible, \" +\n" +
                "                \"ha tenido mucha paciencia para explicar los....."));


        ListAdapter listAdapter = new ListAdapter(elementTeacher, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListTeacher item) {
                moveToDescription(item);
            }

        });
        RecyclerView recyclerView = findViewById(R.id.listarecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }


    //------------------------Pasar Objetos teacher a Descripcion----------------------------------------------//
    public void moveToDescription(ListTeacher item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListTeacher", item);
        startActivity(intent);

    }

    //------------------------Fin de Pasar Objetos teacher a Descripcion----------------------------------------------//


}