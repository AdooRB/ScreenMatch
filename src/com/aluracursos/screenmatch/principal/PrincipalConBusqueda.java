package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorDeConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(true) {
            System.out.println("\nEscriba el nombre de una película:");
            var busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")){
                break;
            }
            try {
                System.out.println("La busqueda -> " + busqueda);
                String busquedaParaURL = URLEncoder.encode(busqueda);
                System.out.println("busquedaParaURL : " + busquedaParaURL);

                String direccion = "http://www.omdbapi.com/?apikey=1432478b&t=" + busquedaParaURL;

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(response.body());

                //Titulo miTitulo = (gson.fromJson(json, Titulo.class));
                TituloOmdb miTituloOmbdb = (gson.fromJson(json, TituloOmdb.class));
                System.out.println(miTituloOmbdb);

                if (miTituloOmbdb.error() == null) {
                    Titulo miTitulo = new Titulo(miTituloOmbdb);
                    System.out.println("Título ya convertido: " + miTitulo);

                    titulos.add(miTitulo);
                }else{
                    System.out.println("Título no encontrado!!");
                }
            } catch (ErrorDeConversionDeDuracionException e) {
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizó la ejecución del programa!!");


    }
}
