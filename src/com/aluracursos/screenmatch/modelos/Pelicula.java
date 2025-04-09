package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String directo;

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
}
