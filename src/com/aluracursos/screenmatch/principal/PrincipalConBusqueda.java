package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("\nEscriba el npmnre de una pelicula:");
        var busqueda = lectura.nextLine().replace(" ", "+");
        System.out.println("La busqueda -> " + busqueda);

        String direccion = "http://www.omdbapi.com/?apikey=1432478b&t=" + busqueda + "";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(response.body());

        Gson gson = new Gson();
        Titulo miTitulo = (gson.fromJson(json, Titulo.class));
        System.out.println(miTitulo);

    }
}
