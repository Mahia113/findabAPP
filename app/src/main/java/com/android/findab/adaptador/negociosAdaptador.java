package com.android.findab.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.findab.R;
import com.android.findab.modelo.Negocios;

import java.util.List;

/**
 * Created by josel on 21/05/2017.
 */

public class negociosAdaptador extends RecyclerView.Adapter<negociosAdaptador.negociosViewHolder>
    implements View.OnClickListener
{
    private List<Negocios> negocios;

    private View.OnClickListener listener;

    public negociosAdaptador(List<Negocios> negocios)
    {
        this.negocios = negocios;
    }

    @Override
    public negociosViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_negocio, parent, false);

        v.setOnClickListener(this);

        return new negociosAdaptador.negociosViewHolder(v);
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

    @Override
    public void onBindViewHolder(negociosViewHolder negociosViewHolder, int position)
    {
        Negocios negocio = negocios.get(position);

        negociosViewHolder.imagenNegocio.setImageResource(negocio.getImagenNegocio());
        negociosViewHolder.nombreNegocio.setText(negocio.getNombreNegocio());
        negociosViewHolder.tiempoFisicamente.setText(negocio.getTiempoFisicamente());
        negociosViewHolder.tiempoDomicilio.setText(negocio.getTiempoDomicilio());
        negociosViewHolder.calificacion.setText(negocio.getCalificacion());
        negociosViewHolder.colorNegocio.setImageResource(negocio.getColorNegocio());
    }

    @Override
    public int getItemCount() {
        return negocios.size();
    }


    public static class negociosViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imagenNegocio;
        private TextView nombreNegocio;
        private TextView tiempoFisicamente;
        private TextView tiempoDomicilio;
        private TextView calificacion;
        private ImageView colorNegocio;

        public negociosViewHolder(View itemView)
        {
            super(itemView);

            imagenNegocio = (ImageView) itemView.findViewById(R.id.imagen_negocio);
            nombreNegocio = (TextView) itemView.findViewById(R.id.nombre_negocio);
            tiempoFisicamente = (TextView) itemView.findViewById(R.id.tiempo_fisicamente);
            tiempoDomicilio = (TextView) itemView.findViewById(R.id.tiempo_domicilio);
            calificacion = (TextView) itemView.findViewById(R.id.lista_negocios_calificacion);
            colorNegocio = (ImageView) itemView.findViewById(R.id.icon_color);
        }
    }
}
