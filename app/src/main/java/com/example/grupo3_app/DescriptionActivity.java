package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupo3_app.Adapter.DescriptionAdapter;
import com.example.grupo3_app.Adapter.TeachersAdapter;
import com.example.grupo3_app.Networks.GetTeachers;
import com.example.grupo3_app.Networks.GetUsuario;
import com.example.grupo3_app.Opinions.ListAdapterOpinion;
import com.example.grupo3_app.Opinions.ListOpinions;
import com.example.grupo3_app.Teacher.ListTeacher;
import com.example.grupo3_app.Teacher.Teacher;
import com.example.grupo3_app.User.User;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    TextView titleDescription, titleAsignaturaDescription, titleStatusdescription, titleOpinionDescription;
    Button escribirComentario;
    EditText boton_escribirComent;
    ImageButton verContactos;
    List<ListOpinions> opinions;
    private ListTeacher teacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        escribirComentario = (Button) findViewById(R.id.idEscribirComentario);

//        init();


//        CREAR FUNCION PARA LLAMAR DATOS DE USUARIO
        datosperfil();

//        CREAR FUNCION PARA LLAMAR DATOS DE OPINIONES
        aniadiropinion(); //HACERLO Y TERMINAR

        ListTeacher element = (ListTeacher) getIntent().getSerializableExtra("ListTeacher");
        titleDescription = findViewById(R.id.titleDescriptionStudents);
        titleAsignaturaDescription = findViewById(R.id.titleAsignaturaDescriptionStudents);
        titleStatusdescription = findViewById(R.id.titleStatusDescriptionStudents);
        titleOpinionDescription = findViewById(R.id.titleOpinionDescriptionStudents);

        teacher = element;

        titleDescription.setText(element.getName());
        titleDescription.setTextColor(Color.parseColor(element.getColor()));

        titleAsignaturaDescription.setText(element.getAsignatura());

        titleStatusdescription.setText(element.getStatus());
        titleStatusdescription.setTextColor(Color.GRAY);

        titleOpinionDescription.setText(element.getOpinion());


        verContactos = (ImageButton) findViewById(R.id.verContactos);
        verContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(element);
            }
        });

        escribirComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CampoComentario();
            }
        });
    }


//    public void init() {
//
//        opinions = new ArrayList<>();
//        opinions.add(new ListOpinions("23", "Silvia", "7", "Uno de los mejores profesores de la historia", "12/01/2022"));
//        opinions.add(new ListOpinions("43", "Maria Carey", "6", "excelente manera de explicar teareas complejas", "12/01/2022"));
//        opinions.add(new ListOpinions("55", "Jon Etxeberria", "1", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
//        opinions.add(new ListOpinions("86", "Rodrigo Armoa", "9", "Uno de los mejores profesores de la historia", "12/01/2022"));
//        opinions.add(new ListOpinions("86", "Pablo Picasso", "3", "excelente manera de explicar teareas complejas", "12/01/2022"));
//        opinions.add(new ListOpinions("66", "Ezequiel Lavezzi", "5", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
//        opinions.add(new ListOpinions("32", "Mirella ", "8", "Uno de los mejores profesores de la historia", "12/01/2022"));
//
//
//        ListAdapterOpinion listAdapterOpinion = new ListAdapterOpinion(opinions, this, new ListAdapterOpinion.OnItemClickListener() {
//            @Override
//            public void onItemClick(ListOpinions item) {
//
//            }
//
//            public int hashCode() {
//                return super.hashCode();
//            }
//
//            public boolean equals(@Nullable Object obj) {
//
//                return super.equals(obj);
//            }
//
//            protected Object clone() throws CloneNotSupportedException {
//                return super.clone();
//            }
//
//            public String toString() {
//                return super.toString();
//
//            }
//
//            protected void finalize() throws Throwable {
//                super.finalize();
//            }
//        });
//
//        RecyclerView recyclerView = findViewById(R.id.RecyclerViewOpinion);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(listAdapterOpinion);
//    }



    private void showAlertDialog(ListTeacher teacher) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ponte en contacto a traves de...");
        builder.setMessage("Asignatura "+ teacher.getAsignatura()
                +" \n Tel: +34 332 454 654"
                +" \n emailemail@email.com");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Acción a realizar al presionar el botón OK
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Acción a realizar al presionar el botón Cancel
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    public void CampoComentario() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DescriptionActivity.this);
        // Get the layout inflater
        LayoutInflater inflater = DescriptionActivity.this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.layout_escribir_opinion, null))
                // Add action buttons
                .setPositiveButton(R.string.boton_escribirComent, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                   boton_escribirComent=findViewById(R.id.CampodeComentario);



//                   INSERTAR AQUI EL CREATE DE OPINIONES



                   //opinions.add(new ListOpinions(teacher.getTeacher(),teacher.getOpinion(),teacher.getStatus(),teacher.getName(),teacher.));
                       // opinions.add(new ListOpinions("AAAMR", "Jon Etxeberria", "1",boton_escribirComent.getText().toString() , "12/01/2022"));

                    }


                })
                .setNegativeButton(R.string.boton_CancelarescribirComent, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void datosperfil() {
        ArrayList<User> lista = new ArrayList<>();

        DescriptionAdapter descriptionAdapter = new DescriptionAdapter (this, R.layout.lista_elementos, lista);
        ((ListView) findViewById( R.id.listarecyclerview)).setAdapter (descriptionAdapter);

        if (isConnected()) {
            GetUsuario users = new GetUsuario();
            Thread thread = new Thread(users);
            try {
                thread.start();
                thread.join(); // Awaiting response from the server...
            } catch (InterruptedException e) {
                // Nothing to do here...
            }
            // Processing the answer
            ArrayList<User> listaCanciones = users.getResponse();
            lista.addAll( listaCanciones );
            ((ListView) findViewById( R.id.listarecyclerview)).setAdapter (descriptionAdapter);
        }
    }

    private void aniadiropinion() {
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
            ArrayList<Teacher> listaCanciones = teachers.getResponse();
            lista.addAll( listaCanciones );
            ((ListView) findViewById( R.id.listarecyclerview)).setAdapter (teachersAdapter);
        }
    }


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
