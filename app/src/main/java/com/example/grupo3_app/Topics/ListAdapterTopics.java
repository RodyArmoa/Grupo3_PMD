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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class  ListAdapterTopics extends RecyclerView.Adapter<ListAdapterTopics.ViewHolder>{

    private List<Listelementtopic> mData;
    private List<Listelementtopic> listaBuscar;
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
        listaBuscar = new ArrayList<>();
        listaBuscar.addAll(mData);

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

    public void buscarAsignatura(String buscarAsignatura){
        int longitud = buscarAsignatura.length();
        if (longitud==0){
            mData.clear();
            mData.addAll(listaBuscar);
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Listelementtopic> colleccion = mData.stream().filter(i -> i.getName().toLowerCase().contains(buscarAsignatura.toLowerCase())).collect(Collectors.toList());
                mData.clear();
                mData.addAll(colleccion);
            }else {
                for (Listelementtopic topic: listaBuscar) {
                    if (topic.getName().toLowerCase().contains(buscarAsignatura.toLowerCase())){
                        mData.add(topic);
                    }
                    
                }
            }
        }
        notifyDataSetChanged();
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
