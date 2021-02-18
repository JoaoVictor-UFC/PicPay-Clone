package com.clonepicpay.erco.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.clonepicpay.erco.R;
import com.clonepicpay.erco.model.Cartao;

import java.util.List;

public class AdapterCartoes extends RecyclerView.Adapter <AdapterCartoes.MyViewHolder> {
    private List<Cartao> listaCartoes;
    public AdapterCartoes(List<Cartao> lista) {this.listaCartoes = lista;}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_lista_cartao,
                parent,
                false
        );

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Cartao c = listaCartoes.get(position);

        holder.apelido.setText(c.getApelidoCartao());
        holder.marca.setText(c.getMarca());
        holder.numero.setText(c.getNumero());
    }

    @Override
    public int getItemCount() {
        return listaCartoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView apelido;
        TextView marca;
        TextView numero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            apelido     = itemView.findViewById(R.id.textApelidoCartao);
            marca       = itemView.findViewById(R.id.textMarcaCartao);
            numero      = itemView.findViewById(R.id.textNumeroCartao);
        }
    }
}
