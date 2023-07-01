package com.example.bebaagua;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private final Context context;
    private List<Boolean> listCopos;

    private OnItemClickListener onItemClickListener;

    public ListAdapter(Context context, List<Boolean> listCopos){
        this.context = context;
        this.listCopos = listCopos;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_lista, parent, false);

        return new ListViewHolder(viewCriada);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        Boolean statusCopo = listCopos.get(position);
        holder.vincularCopo(statusCopo, position);
        if (onItemClickListener != null){

        }
    }

    @Override
    public int getItemCount() {
        return listCopos.size();
    }

    public void reconfigurar(List<Boolean> listaDeCopos) {
        this.listCopos = listaDeCopos;
        this.notifyDataSetChanged();

    }

    class ListViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView desc;
        private Integer position;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iconeagua);
            desc = itemView.findViewById(R.id.txticone);


        }

        public void vincularCopo(Boolean statusCopo, int posicao) {
            itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClick(statusCopo, posicao);
            });
            this.position = posicao;
            if (statusCopo == true){
                this.imageView.setImageResource(R.drawable.garrafadeagua);
            } else{
                this.imageView.setImageResource(R.drawable.garrafadeaguavazia);
            }
            this.desc.setText("150 ml");
        }
    }
}
