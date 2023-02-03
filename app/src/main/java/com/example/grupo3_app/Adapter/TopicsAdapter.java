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
import com.example.grupo3_app.Topics.Topics;

import java.util.ArrayList;

public class TopicsAdapter extends ArrayAdapter<Topics> {
    private final ArrayList<Topics> lista;
    private final Context context;
    public TopicsAdapter(@NonNull Context context, int resource, ArrayList<Topics> lista) {
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
        int i= 0;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate ( R.layout.lista_elementos_asignaturas, null);
        ((TextView) view.findViewById( R.id.nameAsignaturaTextView)).setText(lista.get(position).getName());
        ((TextView) view.findViewById( R.id.statusTextViewAsignatura)).setText("Turno");
        ((TextView) view.findViewById( R.id.teacherTextView)).setText("Profesor");
        ((ImageView) view.findViewById(R.id.iconImageViewAsignaturas)).setColorFilter(Color.parseColor("black"), PorterDuff.Mode.SRC_IN);
        return view;
    }
}
