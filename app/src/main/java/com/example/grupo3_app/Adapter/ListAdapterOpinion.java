package com.example.grupo3_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo3_app.Opinions.ListOpinions;
import com.example.grupo3_app.R;

import java.util.List;



    public class ListAdapterOpinion extends RecyclerView.Adapter<ListAdapterOpinion.ViewHolder>{

        private List<ListOpinions> mData;
        private LayoutInflater mInflater;
        private Context context;
        ListAdapterOpinion.OnItemClickListener listener;

        public interface OnItemClickListener {
            void onItemClick(ListOpinions item);
        }

        public ListAdapterOpinion(List<ListOpinions> itemList, Context context, OnItemClickListener listener){
            this.mInflater= LayoutInflater.from(context);
            this.context=context;
            this.mData=itemList;
            this.listener = (ListAdapterOpinion.OnItemClickListener) listener;

        }



        @Override
        public ListAdapterOpinion.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.lista_elementos_opiniones,null);
            return new ListAdapterOpinion.ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ListAdapterOpinion.ViewHolder holder, int position) {
            holder.bindData(mData.get(position));

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public void setItems(List<ListOpinions> items){ mData=items;
        }



        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView iconImage;
            TextView name, teacher, status;
            ViewHolder(View itemView){
                super(itemView);
                iconImage=itemView.findViewById(R.id.iconImageViewOpinion);
                name=itemView.findViewById(R.id.idStudenComentTextView);
                teacher=itemView.findViewById(R.id.campoOpinionTextView);
                status=itemView.findViewById(R.id.dateTextViewOpinion);

            }
            void bindData(final ListOpinions item1){

              name.setText(item1.getIdTEACHER());
              teacher.setText(item1.getOpinion());
              status.setText(item1.getDate());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        listener.onItemClick(item1);
                    }
                });
            }
        }


    }

