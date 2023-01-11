package com.example.grupo3_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.EventLogTags;

import com.example.grupo3_app.beans.LisAdapter;
import com.example.grupo3_app.beans.ListTeacher;

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

    public void init() {

        elementTeacher = new ArrayList<>();
        elementTeacher.add(new ListTeacher("#775447", "Pedro", "Diseño Interfaces", "Bilbao","Este profe es el puto amo, me ha " +
                "facilitado mucho con las tareas de clases.."));
        elementTeacher.add(new ListTeacher("#76D7C4", "Aitana", "Programacion Web", "Vitoria", "Es una profesora increible, " +
                "ha tenido mucha paciencia para explicar los...."));
        elementTeacher.add(new ListTeacher("#717D7E", "Lucia", "Base de Datos", "Bilbao", "no tiene opinion.."));
        elementTeacher.add(new ListTeacher("#76448A", "Iñaki", "Programacion Web", "Vitoria","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#633974", "Jon", "Programacion Web", "Bilbao","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#0B5345", "Mikel", "Microsoft Azure ", "Donosti","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#D68910", "Joseba", "Machine learning ", "Vitoria","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#BA4A00", "Asier", "Acceso a Datos", "Bilbao","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#922B21", "Borja", "Big Data Analytics", "Ausente","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#775447", "Aitxiber", "Lenguaje de marcas", "Donosti","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#775447", "Rodrigo", "Sistemas Informaticos", "Donosti","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#76D7C4", "Asier", "Programacion .NET", "Vitoria","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));
        elementTeacher.add(new ListTeacher("#717D7E", "David", "Entorno de Desarrollo", "Donosti","Un profesor bastante flojo, cobra mucho para lo que enseña, decepcion."));


        LisAdapter lisAdapter = new LisAdapter(elementTeacher, this, new LisAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListTeacher item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listarecyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lisAdapter);
    }

    public void moveToDescription(ListTeacher item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListTeacher", item);
        startActivity(intent);
    }
}