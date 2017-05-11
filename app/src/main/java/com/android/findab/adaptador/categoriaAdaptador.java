package com.android.findab.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.findab.R;

import com.android.findab.modelo.categoria;

import java.util.List;

/**
 * Created by josel on 11/05/2017.
 */

public class categoriaAdaptador extends RecyclerView.Adapter<categoriaAdaptador.categoriaViewholder>
{
    private List<categoria> categoria;

    public categoriaAdaptador(List<categoria> editoriales)
    {
        this.categoria = categoria;
    }

    @Override
    public categoriaViewholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_editorial, parent, false);

        return new categoriaViewholder(v);
    }

    @Override
    public void onBindViewHolder(EditorialViewholder holder, int position)
    {
        Editorial editorial = editoriales.get(position);

        holder.imagenEditorial.setImageResource(editorial.getFotoEditorial());
    }

    @Override
    public int getItemCount() {
        return editoriales.size();
    }

    public static class EditorialViewholder extends RecyclerView.ViewHolder
    {
        private ImageView imagenEditorial;

        public EditorialViewholder(View itemView)
        {
            super(itemView);
            imagenEditorial = (ImageView)itemView.findViewById(R.id.imagen_editorial);
        }
    }
}

