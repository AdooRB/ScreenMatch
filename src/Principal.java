import com.aluracursos.screenmatch.modelos.Pelicula;

public class Principal {
    public static void main(String[] args) {
        //Primera película
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

       miPelicula.muestraFichaTecnica();
       miPelicula.evalua(7.8);
       miPelicula.evalua(10);
       miPelicula.evalua(10);


        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        //Segunda película
//        com.aluracursos.screenmatch.modelos.Pelicula otraPelicula = new com.aluracursos.screenmatch.modelos.Pelicula();
//        otraPelicula.nombre = "Matrix";
//        otraPelicula.fechaDeLanzamiento = 1994;
////        otraPelicula.muestraFichaTecnica();
//
//        //Tercera Película
//        com.aluracursos.screenmatch.modelos.Pelicula tercerPelicula = new com.aluracursos.screenmatch.modelos.Pelicula();
//        tercerPelicula.nombre = "La famila del futuro";
//        tercerPelicula.fechaDeLanzamiento = 2007;
//        tercerPelicula.duracionEnMinutos = 95;
//        tercerPelicula.incluidoEnElPlan = true;
//
//        tercerPelicula.muestraFichaTecnica();
//        tercerPelicula.evalua(10);
//        tercerPelicula.evalua(10);
//        tercerPelicula.evalua(10);
//
//        System.out.println("Media de evaluaciones de la película: " + tercerPelicula.calculaMedia());
  }
}
