package reto2;

import java.io.*;
import java.nio.file.*;

public class AnalizadorDeLogs {

    public static void main(String[] args) {
        Path rutaArchivoLog= Paths.get("errores.log");
        Path rutaRegistroFallos= Paths.get("registro_fallos.txt");

        int totalLineas= 0;
        int errores= 0;
        int advertencias= 0;

        try (BufferedReader lector= Files.newBufferedReader(rutaArchivoLog)) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    errores++;
                }

                if (linea.contains("WARNING")) {
                    advertencias++;
                }
            }

            System.out.println("Resumen del análisis de logs:");
            System.out.println("Total de líneas leídas: "+ totalLineas);
            System.out.println("Cantidad de errores: " +errores);
            System.out.println("Cantidad de advertencias: "+ advertencias);

            double porcentaje= 100.0 * (errores + advertencias) / totalLineas;
            System.out.printf("Porcentaje de líneas con errores/advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());

            // Guardar el mensaje de error en un archivo
            try {
                Files.writeString(rutaRegistroFallos, "Ocurrió un error al analizar el log:\n"+ e.getMessage());
                System.out.println("Se ha guardado el error en: "+ rutaRegistroFallos);
            } catch (IOException ex) {
                System.err.println("Además, falló al guardar el registro de fallos: "+ex.getMessage());
            }
        }
    }
}
