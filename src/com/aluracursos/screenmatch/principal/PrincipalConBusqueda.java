package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("\nEscriba el nombre de una película:");
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

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        //Titulo miTitulo = (gson.fromJson(json, Titulo.class));
        TituloOmdb miTituloOmbdb = (gson.fromJson(json, TituloOmdb.class));
        System.out.println(miTituloOmbdb);
        Titulo miTitulo = new Titulo(miTituloOmbdb);
        System.out.println(miTitulo.toString());

    }
}
