package com.alg.hozon_01;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class ECategorias implements Comparable<ECategorias> {
    private String strCategoria;

    public ECategorias(String strCategoria) {
        this.strCategoria = strCategoria;
    }

    @NonNull
    @Override
    public String toString() {

        return strCategoria;
    }

    @Override
    public int compareTo(ECategorias categoria) {
        return strCategoria.compareTo(categoria.toString());
    }

    public void setName(String strCategoria) {
        this.strCategoria = strCategoria;
    }

    public static DiffUtil.ItemCallback<ECategorias> categoriaDiffCallback = new DiffUtil.ItemCallback<ECategorias>() {
        @Override
        public boolean areItemsTheSame(@NonNull ECategorias oldItem, @NonNull ECategorias newItem) {
            return oldItem.toString().equals(newItem.toString());
        }

        @Override
        public boolean areContentsTheSame(@NonNull ECategorias oldItem, @NonNull ECategorias newItem) {
            return oldItem.toString().equals(newItem.toString());
        }
    };

}