package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grupo3_app.Opinions.ListAdapterOpinion;
import com.example.grupo3_app.Opinions.ListOpinions;
import com.example.grupo3_app.Teacher.ListTeacher;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    TextView titleDescription, titleAsignaturaDescription, titleStatusdescription, titleOpinionDescription;
    Button escribirComentario;
    EditText boton_escribirComent;
    ImageButton verContactos;
    List<ListOpinions> opinions;
    private ListTeacher teacher;

    private ImageButton myImageButtonFavoritos;
    private boolean isImage1 = true;

    private String phoneNumber = "tel:1234567890";
    private static final int REQUEST_CALL = 1;
    private Intent callIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        escribirComentario = (Button) findViewById(R.id.idEscribirComentario);

//----------Creamos un ImageButton para Favorivos en el cual al pulsar añadimos a la lista de favoritos--------
        myImageButtonFavoritos = findViewById(R.id.idImageButtonFavoritos);

        myImageButtonFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImage1) {
                    myImageButtonFavoritos.setImageResource(R.drawable.ic_imagebuttonfavorito_2);
                    isImage1 = false;
                } else {
                    myImageButtonFavoritos.setImageResource(R.drawable.ic_favorito_description);
                    isImage1 = true;
                    Toast.makeText(DescriptionActivity.this, "Se añadió a Favoritos", Toast.LENGTH_SHORT).show();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isImage1) {
                            myImageButtonFavoritos.setImageResource(R.drawable.ic_favorito_description);
                        } else {
                            myImageButtonFavoritos.setImageResource(R.drawable.ic_imagebuttonfavorito_2);
                        }
                        isImage1 = !isImage1;
                    }
                }, 2000); // 2 seconds
            }
        });
//---------Fin del metodo de ImageButtonFavorito en el cual al pulsar cambia de imagen-------------------------////


        init();

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

        //----------------PRUEBA DE VER CONTACTO PARA UNA LLAMADA DIRECTA------------//

        verContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DescriptionActivity.this);
                builder.setTitle("Realizar llamada");
                builder.setMessage("¿Desea realizar la llamada a " + phoneNumber + "?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse(phoneNumber));
                        if (ContextCompat.checkSelfPermission(DescriptionActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(DescriptionActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                        } else {
                            startActivity(callIntent);
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                if (requestCode == REQUEST_CALL) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        startActivity(callIntent);
                    } else {
                        Toast.makeText(DescriptionActivity.this, "Permiso Denegado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //---------------- FIN PRUEBA DE VER CONTACTO PARA UNA LLAMADA DIRECTA------------//


       /* verContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(element);
            }
        });*/

        escribirComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CampoComentario();
            }
        });
    }


    public void init() {

        opinions = new ArrayList<>();
        opinions.add(new ListOpinions("23", "Silvia", "7", "Uno de los mejores profesores de la historia", "12/01/2022"));
        opinions.add(new ListOpinions("43", "Maria Carey", "6", "excelente manera de explicar teareas complejas", "12/01/2022"));
        opinions.add(new ListOpinions("55", "Jon Etxeberria", "1", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
        opinions.add(new ListOpinions("86", "Rodrigo Armoa", "9", "Uno de los mejores profesores de la historia", "12/01/2022"));
        opinions.add(new ListOpinions("86", "Pablo Picasso", "3", "excelente manera de explicar teareas complejas", "12/01/2022"));
        opinions.add(new ListOpinions("66", "Ezequiel Lavezzi", "5", "No me esperaba encontra una persona con tanta paciencia para esta asignatura", "12/01/2022"));
        opinions.add(new ListOpinions("32", "Mirella ", "8", "Uno de los mejores profesores de la historia", "12/01/2022"));


        ListAdapterOpinion listAdapterOpinion = new ListAdapterOpinion(opinions, this, new ListAdapterOpinion.OnItemClickListener() {
            @Override
            public void onItemClick(ListOpinions item) {

            }

            public int hashCode() {
                return super.hashCode();
            }

            public boolean equals(@Nullable Object obj) {

                return super.equals(obj);
            }

            protected Object clone() throws CloneNotSupportedException {
                return super.clone();
            }

            public String toString() {
                return super.toString();

            }

            protected void finalize() throws Throwable {
                super.finalize();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.RecyclerViewOpinion);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapterOpinion);
    }

//----metodo para ver un AlerDialog del usuario---------------------------------//

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

//----FIN del metodo para ver un AlerDialog del usuario---------------------------------//

 //-----Metodo para escribir un comentario en DescripcionActiviy---------------------//

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

    //-----FIN del Metodo para escribir un comentario en DescripcionActiviy---------------------//


}
