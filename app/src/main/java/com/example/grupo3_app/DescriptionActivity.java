package com.example.grupo3_app;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.grupo3_app.beans.ListTeacher;

public class DescriptionActivity extends AppCompatActivity {
    TextView titleDescription, titleAsignaturaDescription, titleStatusdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListTeacher element = (ListTeacher) getIntent().getSerializableExtra("ListTeacher");
        titleDescription = findViewById(R.id.titleDescription);
        titleAsignaturaDescription = findViewById(R.id.titleAsignaturaDescription);
        titleStatusdescription = findViewById(R.id.titleStatusDescription);

        titleDescription.setText(element.getName());
        titleDescription.setTextColor(Color.parseColor(element.getColor()));

        titleAsignaturaDescription.setText(element.getAsignatura());

        titleStatusdescription.setText(element.getStatus());
        titleStatusdescription.setTextColor(Color.GRAY);
    }
}