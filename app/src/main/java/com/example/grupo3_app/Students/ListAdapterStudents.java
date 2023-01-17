package com.example.grupo3_app.Students;


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

import java.util.List;

public class ListAdapterStudents extends RecyclerView.Adapter<ListAdapterStudents.ViewHolder> {

    private List<ListStudents> mData;
    private LayoutInflater mInflater;
    private Context context;
    final com.example.grupo3_app.Students.ListAdapterStudents.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListStudents item);

    }

    public ListAdapterStudents(List<ListStudents> itemList, Context context, OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;


        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lista_elementos, null);

        return new ListAdapterStudents.ViewHolder(view);

                // beans.ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<ListStudents> items) {
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

        void bindData(final ListStudents item) {
            iconImage.setColorFilter(Color.parseColor(item.Name), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            asignatura.setText(item.Surname);
            status.setText(item.Phone);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });

        }
    }
}
