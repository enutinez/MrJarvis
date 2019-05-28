package com.enuarmartinez.rentamen;

public class Offer {
    private String Titulo, Descripcion, Celular;
    private Float Precio;

    public Offer(String titulo, String descripcion, Float precio, String celular) {
        Titulo = titulo;
        Descripcion = descripcion;
        Precio = precio;
        Celular = celular;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float precio) {
        Precio = precio;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public void SaveOffer(){
        DataOffer.Save(this);
    }

}
