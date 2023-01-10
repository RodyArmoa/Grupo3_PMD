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
        elementTeacher.add(new ListTeacher("#775447", "Pedro", "Diseño Interfaces", "Disponible"));
        elementTeacher.add(new ListTeacher("#76D7C4", "Aitana", "Programacion Web", "Disponible"));
        elementTeacher.add(new ListTeacher("#717D7E", "Lucia", "Base de Datos", "Ausente"));
        elementTeacher.add(new ListTeacher("#76448A", "Iñaki", "Programacion Web", "Disponible"));
        elementTeacher.add(new ListTeacher("#633974", "Jon", "Programacion Web", "Ausente"));
        elementTeacher.add(new ListTeacher("#0B5345", "Mikel", "Microsoft Azure ", "Disponible"));
        elementTeacher.add(new ListTeacher("#D68910", "Joseba", "Machine learning ", "Disponible"));
        elementTeacher.add(new ListTeacher("#BA4A00", "Asier", "Acceso a Datos", "Ausente"));
        elementTeacher.add(new ListTeacher("#922B21", "Borja", "Big Data Analytics", "Ausente"));
        elementTeacher.add(new ListTeacher("#775447", "Aitxiber", "Lenguaje de marcas", "Disponible"));
        elementTeacher.add(new ListTeacher("#775447", "Rodrigo", "Sistemas Informaticos", "Disponible"));
        elementTeacher.add(new ListTeacher("#76D7C4", "Asier", "Programacion .NET", "Disponible"));
        elementTeacher.add(new ListTeacher("#717D7E", "David", "Entorno de Desarrollo", "Ausente"));


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