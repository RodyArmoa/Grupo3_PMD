package com.example.grupo3_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.grupo3_app.R;
import com.example.grupo3_app.User.User;

import java.util.ArrayList;

public class DescriptionAdapter extends ArrayAdapter<User> {
    private final ArrayList<User> lista;
    private final Context context;
    public DescriptionAdapter(@NonNull Context context, int resource, ArrayList<User> lista) {
        super(context, resource,lista);
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount (){
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parents) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.activity_description, null);
        String nombre = lista.get(position).getName() + lista.get(position).getSurname();
        String id = lista.get(position).getId().toString();
        String telefono = lista.get(position).getPhone();
        ((TextView) view.findViewById( R.id.titleDescriptionStudents)).setText(nombre);
        ((TextView) view.findViewById( R.id.titleStatusDescriptionStudents)).setText(lista.get(position).getShift());
        ((TextView) view.findViewById( R.id.titleAsignaturaDescriptionStudents)).setText("Asignatura");
        ((TextView) view.findViewById( R.id.titleOpinionDescriptionStudents)).setText(lista.get(position).getDescription());

//        Falta terminar layout
        view.findViewById(R.id.verContactos).setContentDescription(telefono);
        view.findViewById(R.id.fotoPerfilImageView).setContentDescription(id);
        return view;
    }
}
