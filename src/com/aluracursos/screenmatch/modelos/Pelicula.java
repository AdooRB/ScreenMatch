package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String directo;

    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public void setDirecto(String directo) {
        this.directo = directo;
    }

    public String getDirecto() {
        return directo;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Pelicula: " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";
    }
}
