package com.example.grupo3_app.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.grupo3_app.R;
import com.example.grupo3_app.Teacher.Teacher;

import java.util.ArrayList;


public class TeachersAdapter extends ArrayAdapter<Teacher> {
    private final ArrayList<Teacher> lista;
    private final Context context;
    public TeachersAdapter(@NonNull Context context, int resource, ArrayList<Teacher> lista) {
        super(context, resource,lista);
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount (){
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parents){
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate ( R.layout.lista_elementos, null);
        String nombre = lista.get(position).getName() + lista.get(position).getSurname();

        ((TextView) view.findViewById( R.id.nameTextView)).setText(nombre);
        ((TextView) view.findViewById( R.id.statusTextView)).setText(lista.get(position).getLocation());
        ((TextView) view.findViewById( R.id.asignaturaTexView)).setText("Asignatura");
        ((ImageView) view.findViewById(R.id.iconImageViewStudents)).setColorFilter(Color.parseColor("red"), PorterDuff.Mode.SRC_IN);
        return view;
    }
}
