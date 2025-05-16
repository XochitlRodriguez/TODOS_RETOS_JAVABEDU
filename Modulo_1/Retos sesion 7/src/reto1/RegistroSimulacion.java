package reto1;

import java.io.IOException;
import java.nio.file.*;

public class RegistroSimulacion {

    public static void main(String[] args) {
        Path rutaArchivo= Paths.get("config/parametros.txt");

        guardarParametros(rutaArchivo);

        if (Files.exists(rutaArchivo)) {
            System.out.println("Archivo creado correctamente.\n");
            leerParametros(rutaArchivo);
        } else {
            System.out.println("No se pudo crear el archivo.");
        }
    }

    // Método para guardar los parámetros en un archivo
    public static void guardarParametros(Path ruta) {
        try {

            //Se crea la carpeta en caso necesario y se nombra al archivo

            Path carpeta = ruta.getParent();
            if (!Files.exists(carpeta)) {
                Files.createDirectories(carpeta);
            }

            String contenido= """
                Tiempo de ciclo: 55.8 segundos
                Velocidad de línea: 1.2 m/s
                Número de estaciones: 8
                """;

            Files.write(ruta, contenido.getBytes());
            System.out.println("Parámetros guardados en " + ruta.toString());

        } catch (IOException e) {
            System.err.println("Error al guardar los parámetros: " + e.getMessage());
        }
    }

    //Metodo para leer y mostrar el contenido del archivo//

    public static void leerParametros(Path ruta) {
        try {
            String contenido= Files.readString(ruta);
            System.out.println("Contenido del archivo: "+ contenido);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: "+ e.getMessage());
        }
    }
}

