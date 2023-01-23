package com.example.grupo3_app.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo3_app.R;
import com.example.grupo3_app.Teacher.ListTeacher;

import java.util.List;

public class ListAdapterTeacher extends RecyclerView.Adapter<ListAdapterTeacher.ViewHolder> {

    private List<ListTeacher> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapterTeacher.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListTeacher item);

    }

    public ListAdapterTeacher(List<ListTeacher> itemList, Context context, ListAdapterTeacher.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public ListAdapterTeacher.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lista_elementos, null);

        return new ListAdapterTeacher.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterTeacher.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<ListTeacher> items) {
        mData = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconImage;
        TextView name, asignatura, status;

        ViewHolder(View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageViewStudents);
            name = itemView.findViewById(R.id.nameTextView);
            asignatura = itemView.findViewById(R.id.asignaturaTexView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListTeacher item) {
            String nombre = item.getName() + item.getSurname();
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(nombre);
            asignatura.setText(item.getAsignatura());
            status.setText(item.getStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onItemClick(item);
                }
            });

        }
    }
}
