package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.grupo3_app.Opinions.ListAdapterOpinion;
import com.example.grupo3_app.Opinions.ListOpinions;
import com.example.grupo3_app.Teacher.ListTeacher;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    TextView titleDescription, titleAsignaturaDescription, titleStatusdescription, titleOpinionDescription;

    List<ListOpinions> opinions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        init();

        ListTeacher element = (ListTeacher) getIntent().getSerializableExtra("ListTeacher");
        titleDescription = findViewById(R.id.titleDescriptionStudents);
        titleAsignaturaDescription = findViewById(R.id.titleAsignaturaDescriptionStudents);
        titleStatusdescription = findViewById(R.id.titleStatusDescriptionStudents);
        titleOpinionDescription = findViewById(R.id.titleOpinionDescriptionStudents);

        titleDescription.setText(element.getName());
        titleDescription.setTextColor(Color.parseColor(element.getColor()));

        titleAsignaturaDescription.setText(element.getAsignatura());

        titleStatusdescription.setText(element.getStatus());
        titleStatusdescription.setTextColor(Color.GRAY);

        titleOpinionDescription.setText(element.getOpinion());
    }

    public void init() {

        opinions = new ArrayList<>();
        opinions.add(new ListOpinions("23", "2", "7", "Uno de los mejores profesores de la historia", "12/01/2022"));
        opinions.add(new ListOpinions("43", "65", "6", "excelente manera de explicar teareas complejas", "12/01/2022"));
        opinions.add(new ListOpinions("55", "44", "1", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
        opinions.add(new ListOpinions("86", "10", "9", "Uno de los mejores profesores de la historia", "12/01/2022"));
        opinions.add(new ListOpinions("86", "23", "3", "excelente manera de explicar teareas complejas", "12/01/2022"));
        opinions.add(new ListOpinions("66", "CR7", "5", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
        opinions.add(new ListOpinions("32", "44", "8", "Uno de los mejores profesores de la historia", "12/01/2022"));


        ListAdapterOpinion listAdapterOpinion = new ListAdapterOpinion(opinions, this, new ListAdapterOpinion.OnItemClickListener() {
            @Override
            public void onItemClick(ListOpinions item) {

            }
            public int hashCode(){
                return super.hashCode();
            }
            public boolean equals(@Nullable Object obj){

                return  super.equals(obj);
            }

            protected  Object clone()throws CloneNotSupportedException{
                return super.clone();
            }
            public String toString(){
                return super.toString();

            }

            protected void finalize() throws Throwable{
                super.finalize();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.RecyclerViewOpinion);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterOpinion);
    }
}
