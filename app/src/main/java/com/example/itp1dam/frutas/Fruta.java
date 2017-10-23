package com.example.itp1dam.frutas;

/**
 * Created by ITP1DAM on 23/10/2017.
 */

public class Fruta {
    private int imagen;
    private String nombre;

    public Fruta(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
