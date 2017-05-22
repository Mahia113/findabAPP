package com.android.findab.modelo;

/**
 * Created by josel on 21/05/2017.
 */

public class Negocios
{
    private int    imagenNegocio;
    private String nombreNegocio;
    private String tiempoFisicamente;
    private String tiempoDomicilio;
    private String calificacion;
    private int    colorNegocio;

    public Negocios(int imagenNegocio, String nombreNegocio, String tiempoFisicamente,
                    String tiempoDomicilio, String calificacion, int colorNegocio)
    {
        this.imagenNegocio = imagenNegocio;
        this.nombreNegocio = nombreNegocio;
        this.tiempoFisicamente = tiempoFisicamente;
        this.tiempoDomicilio = tiempoDomicilio;
        this.calificacion = calificacion;
        this.colorNegocio = colorNegocio;
    }

    public int getImagenNegocio() {
        return imagenNegocio;
    }

    public void setImagenNegocio(int imagenNegocio) {
        this.imagenNegocio = imagenNegocio;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getTiempoFisicamente() {
        return tiempoFisicamente;
    }

    public void setTiempoFisicamente(String tiempoFisicamente) {
        this.tiempoFisicamente = tiempoFisicamente;
    }

    public String getTiempoDomicilio() {
        return tiempoDomicilio;
    }

    public void setTiempoDomicilio(String tiempoDomicilio) {
        this.tiempoDomicilio = tiempoDomicilio;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public int getColorNegocio() {
        return colorNegocio;
    }

    public void setColorNegocio(int colorNegocio) {
        this.colorNegocio = colorNegocio;
    }
}
