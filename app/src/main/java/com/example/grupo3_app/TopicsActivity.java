package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.grupo3_app.Topics.ListAdapterTopics;
import com.example.grupo3_app.Topics.Listelementtopic;

import java.util.ArrayList;
import java.util.List;

public class TopicsActivity extends AppCompatActivity {
    List<Listelementtopic> listelementtopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        init();
    }


    public void init(){

        listelementtopics = new ArrayList<>();
        listelementtopics.add(new Listelementtopic("#0B5345", "Base de Datos","Pedro Gutierrez","Mañana"));
        listelementtopics.add(new Listelementtopic("#B779DD", "Programacion","Juan Notario","Tardes"));
        listelementtopics.add(new Listelementtopic("#9179DD", "Diseño Interfaces","Iñaki Valencia","Mañana"));
        listelementtopics.add(new Listelementtopic("#79CCDD", "Lenguaje de Marcas","Jon Martinez","Tardes"));
        listelementtopics.add(new Listelementtopic("#47747D", "Big Data Analyst","Aitxiber Badalona","Mañana"));
        listelementtopics.add(new Listelementtopic("#7F9093", "Sistemas","Aitor Karanka","Tardes"));
        listelementtopics.add(new Listelementtopic("#6EBDEE", "Microsoft Azure","Juanma Lopez","Mañana"));
        listelementtopics.add(new Listelementtopic("#B4EC28", "Amazon Web Services","Alvaro Benito","Tardes"));
        listelementtopics.add(new Listelementtopic("#79CCDD", "Amazon Web Services","Leire Villamarin","Mañana"));
        listelementtopics.add(new Listelementtopic("#0B5345", "Amazon Web Services","Susana Torres","Tardes"));
        listelementtopics.add(new Listelementtopic("#9179DD", "Amazon Web Services","Luis Medina","Mañana"));

        ListAdapterTopics listAdapterTopics= new ListAdapterTopics(listelementtopics, this, new ListAdapterTopics.OnItemClickListener() {
            @Override
            public void onItemClick(Listelementtopic item) {


            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(@Nullable Object obj) {
                return super.equals(obj);
            }

            @NonNull
            @Override
            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            @NonNull
            @Override
            public String toString() {
                return super.toString();
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listAsignaturasRecyView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterTopics);


    }

}