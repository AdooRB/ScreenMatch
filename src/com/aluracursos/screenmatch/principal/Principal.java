package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        //Primera película
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

       miPelicula.muestraFichaTecnica();
       miPelicula.evalua(7.8);
       miPelicula.evalua(10);
       miPelicula.evalua(10);


        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del Dragón", 2022);
        casaDragon.setTemporada(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        //        Segunda película
        Pelicula otraPelicula = new Pelicula("Matrix",1994);
        otraPelicula.setDuracionEnMinutos(180);
        otraPelicula.muestraFichaTecnica();

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver titulos favoritos estas vaciones: " + calculadora.getTiempoTotal() + " minutos.");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(500);

        filtroRecomendacion.filtra(episodio);
//        //Tercera Película
//        Pelicula tercerPelicula = new Pelicula();
//        tercerPelicula.setNombre("La famila del futuro");
//        tercerPelicula.setFechaDeLanzamiento(2007);
//        tercerPelicula.setDuracionEnMinutos(180);
//        tercerPelicula.setIncluidoEnElPlan(true);
//
//        tercerPelicula.muestraFichaTecnica();
//        tercerPelicula.evalua(10);
//        tercerPelicula.evalua(10);
//        tercerPelicula.evalua(10);
//
//        System.out.println("Media de evaluaciones de la película: " + tercerPelicula.calculaMedia());

        var peliculaDeAldo = new Pelicula("El señor de los anillos", 2001);
        peliculaDeAldo.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePelicula = new ArrayList<>();
        listaDePelicula.add(peliculaDeAldo);
        listaDePelicula.add(miPelicula);
        listaDePelicula.add(otraPelicula);

        System.out.println("Tamaño de lista: " + listaDePelicula.size());
        System.out.println("La primera pelicula es: " + listaDePelicula.get(2).getNombre());
        System.out.println(listaDePelicula);

        System.out.println(listaDePelicula.get(2).toString());

  }
}
