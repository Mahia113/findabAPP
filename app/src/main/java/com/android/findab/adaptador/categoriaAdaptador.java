package com.android.findab.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.findab.R;

import com.android.findab.modelo.Categoria;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by josel on 11/05/2017.
 */

public class categoriaAdaptador extends RecyclerView.Adapter<categoriaAdaptador.categoriaViewHolder>
{
    private List<Categoria> categorias;

    public categoriaAdaptador(List<Categoria> categorias)
    {
        this.categorias = categorias;
    }

    @Override
    public categoriaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_categoria, parent, false);
        return new categoriaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(categoriaViewHolder categoriaViewHolder, int position)
    {
        Categoria categoria = categorias.get(position);
        categoriaViewHolder.imagenCategoria.setImageResource(categoria.getIconCategoria());
        categoriaViewHolder.nombreCategoria.setText(categoria.getNombreCategoria());
    }

    @Override
    public int getItemCount() {
        return categorias.size();
    }

    public static class categoriaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imagenCategoria;
        private TextView nombreCategoria;

        public categoriaViewHolder(View itemView) {
            super(itemView);

            imagenCategoria = (ImageView) itemView.findViewById(R.id.imagen_categoria);
            nombreCategoria = (TextView) itemView.findViewById(R.id.nombre_categoria);
        }
    }
}
