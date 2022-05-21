package com.alg.hozon_01;


import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.alg.hozon_01.ECategorias;
import com.alg.hozon_01.CategoriasViewModel;

import java.util.List;

//import hozon_01.R;

public class CategoriasAdapter extends ListAdapter<ECategorias, CategoriasAdapter.CategoriasViewHolder> {

    //Declaramos una referencia al categoriasViewModel
    private CategoriasViewModel categoriasViewModel;

    protected CategoriasAdapter(@NonNull DiffUtil.ItemCallback<ECategorias> diffCallback, ViewModelStoreOwner owner) {
        super(diffCallback);
        //Instanciamos el categoriasViewModel
        //  El segundo parametro que recibimos debe ser el objeto en donde se creo por primera vez el ViewModel
        //     En este ejemplo es el  CategoriasFragment porque en el se instancia por primera vez
        //  Un (ViewModelStoreOwner) es un objeto con ciclo de vida (una Activity o un Fragment).
        categoriasViewModel = new ViewModelProvider(owner).get(CategoriasViewModel.class);
    }

    @NonNull
    @Override
    public CategoriasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.categoria_row_layout, parent, false);
        return new CategoriasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriasViewHolder holder, int position) {
        ECategorias categoria = getCurrentList().get(position);
        if (categoria != null){
            holder.bind(categoria.toString());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Seleccionado: " + categoria.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CategoriasViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCategoriasItem;
        private ImageButton ibDelete;

        public CategoriasViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoriasItem = itemView.findViewById(R.id.tvCategoriasItem);
            ibDelete = itemView.findViewById(R.id.ibDelete);
            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    categoriasViewModel.deleteCategoria(getLayoutPosition());
                }
            });
        }

        public void bind(String string) {
            tvCategoriasItem.setText(string);
        }
    }

}
