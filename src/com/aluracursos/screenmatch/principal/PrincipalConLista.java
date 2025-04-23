package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;

public class PrincipalConLista {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Serie casaDragon = new Serie("La casa del Dragón", 2022);
        casaDragon.evalua(8);
        Pelicula otraPelicula = new Pelicula("Matrix",1994);
        otraPelicula.evalua(10);
        var favorita = new Pelicula("El señor de los anillos", 2001);
        favorita.evalua(7);
        Pelicula otra = new Pelicula("Jhon Wick", 2014);
        otra.evalua(8);
        Serie serie = new Serie("La Casa de Papel",2017);
        serie.evalua(7);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(favorita);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(casaDragon);
        lista.add(otra);
        lista.add(serie);

//        lista.forEach(Pelicula -> System.out.println(Pelicula));
        for (Titulo item: lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2){
                System.out.println(pelicula.getClasificacion());
            }
        }
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricado Darín");
        System.out.println(listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas oredenada: " + listaDeArtistas);


    }
}
