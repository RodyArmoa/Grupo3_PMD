package com.example.grupo3_app.Topics;

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

public class ListAdapterTopics extends RecyclerView.Adapter<ListAdapterTopics.ViewHolder>{

    private List<Listelementtopic> mData;
    private LayoutInflater mInflater;
    private Context context;
    ListAdapterTopics.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Listelementtopic item);
    }

    public ListAdapterTopics(List<Listelementtopic> itemList, Context context, ListAdapterTopics.OnItemClickListener listener){
        this.mInflater= LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;
        this.listener = (OnItemClickListener) listener;

    }



    @Override
    public ListAdapterTopics.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.lista_elementos_asignaturas,null);
            return new ListAdapterTopics.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapterTopics.ViewHolder holder, int position) {
        holder.bindData(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setItems(List<Listelementtopic> items){ mData=items;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView name, teacher, status;
        ViewHolder(View itemView){
            super(itemView);
            iconImage=itemView.findViewById(R.id.iconImageViewAsignaturas);
            name=itemView.findViewById(R.id.nameAsignaturaTextView);
            teacher=itemView.findViewById(R.id.teacherTextView);
            status=itemView.findViewById(R.id.statusTextViewAsignatura);

        }
       void bindData(final  Listelementtopic item1){
           iconImage.setColorFilter(Color.parseColor(item1.getColor()),PorterDuff.Mode.SRC_IN);
            name.setText(item1.getName());
            teacher.setText(item1.getTeacher());
            status.setText(item1.getStatus());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    listener.onItemClick(item1);

                }
            });
        }
    }


}
