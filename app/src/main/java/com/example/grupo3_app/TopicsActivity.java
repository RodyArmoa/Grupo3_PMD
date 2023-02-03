package com.example.grupo3_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.grupo3_app.Adapter.TeachersAdapter;
import com.example.grupo3_app.Adapter.TopicsAdapter;
import com.example.grupo3_app.Networks.GetTopics;
import com.example.grupo3_app.Topics.ListAdapterTopics;
import com.example.grupo3_app.Topics.Listelementtopic;
import com.example.grupo3_app.Topics.Topics;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TopicsActivity extends AppCompatActivity {
    List<Listelementtopic> listelementtopics;
    BottomNavigationView mbottomNavigationView;
    SearchView buscarAsignatura;
    ListAdapterTopics listAdapterTopics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        //buscarAsignatura = (SearchView) findViewById(R.id.buscarAsignatura)
       // buscarAsignatura.setOnQueryTextListener(this);


        //-----------Barra Menu Inferior---------------------------------------------//
        mbottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonNavigation);
        mbottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_inferior_home) {

                    Intent intent = new Intent(TopicsActivity.this, ComunityActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(TopicsActivity.this, "Home", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_favorite) {


                    Toast.makeText(TopicsActivity.this, "Favoritos", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_perfil) {

                    Intent intent = new Intent(TopicsActivity.this, MiPerfilActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(TopicsActivity.this, "Perfil", Toast.LENGTH_SHORT).show();

                }
                if (item.getItemId() == R.id.menu_inferior_buscar) {

                    Intent intent = new Intent(TopicsActivity.this, TopicsActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_in, R.anim.right_out);

                    Toast.makeText(TopicsActivity.this, "Asignaturas", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });


        ArrayList<Topics> lista = new ArrayList<>();

        TopicsAdapter teachersAdapter = new TopicsAdapter (this, R.layout.lista_elementos_asignaturas, lista);
        ((ListView) findViewById( R.id.listAsignaturasRecyView)).setAdapter (teachersAdapter);



        if (isConnected()) {
            GetTopics getTopics = new GetTopics();
            Thread thread = new Thread(getTopics);
            try {
                thread.start();
                thread.join(); // Awaiting response from the server...
            } catch (InterruptedException e) {
                // Nothing to do here...
            }
            // Processing the answer
            ArrayList<Topics> listateacher = getTopics.getResponse();
            lista.addAll( listateacher );
            ((ListView) findViewById( R.id.listAsignaturasRecyView)).setAdapter (teachersAdapter);
        }

        //-----------------FIn de Barra Menu inferior------------------//



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


  /*
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
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        listAdapterTopics.buscarAsignatura(newText);
        return false;
    }*/
}