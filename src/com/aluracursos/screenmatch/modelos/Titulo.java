package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepcion.ErrorDeConversionDeDuracionException;

public class Titulo implements Comparable<Titulo> {
    //@SerializedName("Title")
    private String nombre;
    //@SerializedName("Year")
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmbdb) {
        this.nombre = miTituloOmbdb.title();
        this.fechaDeLanzamiento = Integer.valueOf(miTituloOmbdb.year());
        if(miTituloOmbdb.runtime().contains("N/A")){
            throw  new ErrorDeConversionDeDuracionException("No pude convertir la duración, " +
                    "porque contiene un N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmbdb.runtime().substring(0,3).replace(" ", ""));
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void muestraFichaTecnica(){
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("El nombre de la película es:  " + nombre);
        System.out.println("Su fecha de lanzamiento es:  " + fechaDeLanzamiento);
        System.out.println("Duración en minutos es:  " + getDuracionEnMinutos());
        System.out.println(" ");
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    public double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "nombre = '" + nombre + '\'' +
                ", fechaDeLanzamiento = " + fechaDeLanzamiento +
                ", duracion = " + duracionEnMinutos;
    }
}
