package com.example.grupo3_app;

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

import java.util.ArrayList;
import java.util.List;

public class ComunityActivity extends AppCompatActivity {
    List<ListTeacher> elementTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity);

        init();


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
    public void init() {

        elementTeacher = new ArrayList<>();
        elementTeacher.add(new ListTeacher("#775447", "Pedro", "Diseño Interfaces", "Bilbao", "Mas de 5 años impartiendo clases a particulares, " +
                "titulado en la Universidad de Toronto, he trabajado en una de las Big"));
        elementTeacher.add(new ListTeacher("#76D7C4", "Aitana", "Programacion Web", "Vitoria", "Es una profesora increible, " +
                "ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#717D7E", "Lucia", "Base de Datos", "Bilbao", "no tiene opinion.."));
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


}