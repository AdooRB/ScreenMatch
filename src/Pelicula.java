public class Pelicula {
    String nombre;
    int fechaDeLanzamiento;
    int duracionEnMinutos;
    boolean incluidoEnElPlan;
    double sumaDeLasEvaluaciones;
    int totalDeLasEvaluaciones;

    void muestraFichaTecnica(){
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("El nombre de la película es:  " + nombre);
        System.out.println("Su fecha de lanzamiento es:  " + fechaDeLanzamiento);
        System.out.println("Duración en minutos es:  " + duracionEnMinutos);
        System.out.println(" ");
    }

    void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeLasEvaluaciones++;
    }

    double calculaMedia(){
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }
}
