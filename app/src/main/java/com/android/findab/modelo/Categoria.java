package com.android.findab.modelo;

/**
 * Created by joseluis on 10/05/2017.
 */

public class Categoria
{
    private int iconCategoria;
    private String nombreCategoria;

    public Categoria(int iconCategoria, String nombreCategoria)
    {
        this.iconCategoria = iconCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIconCategoria()
    {
        return iconCategoria;
    }

    public void setIconCategoria(int iconCategoria)
    {
        this.iconCategoria = iconCategoria;
    }

    public String getNombreCategoria()
    {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria)
    {
        this.nombreCategoria = nombreCategoria;
    }
}
