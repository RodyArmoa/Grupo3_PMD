package com.example.grupo3_app.beans;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo3_app.R;

import java.util.List;

public class LisAdapter extends RecyclerView.Adapter<LisAdapter.ViewHolder> {

    private List<ListTeacher> mData;
    private LayoutInflater mInflater;
    private Context context;
    final LisAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListTeacher item);

    }

    public LisAdapter(List<ListTeacher> itemList, Context context, LisAdapter.OnItemClickListener listener) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;


    }

    @NonNull
    @Override
    public LisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lista_elementos, null);

        return new LisAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LisAdapter.ViewHolder holder, int position) {
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
            iconImage = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            asignatura = itemView.findViewById(R.id.asignaturaTexView);
            status = itemView.findViewById(R.id.statusTextView);
        }

        void bindData(final ListTeacher item) {
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
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
