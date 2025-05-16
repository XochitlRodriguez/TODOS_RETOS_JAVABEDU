package Reto2;

import java.util.HashSet;
import java.util.Scanner;

public class MonitorCPU {
    public static void main(String[] args) {
        Scanner scanner= null;
        HashSet<Double> registros= new HashSet<>();

        try {
            scanner= new Scanner(System.in);
            System.out.println("Monitoreo de consumo de CPU (0-100%). Escribe 'fin' para terminar.");

            while (true) {
                System.out.print("Ingresa consumo de CPU: ");
                String entrada= scanner.nextLine();

                if (entrada.equalsIgnoreCase("fin")) {
                    break;
                }

                double valor;

                try {
                    valor= Double.parseDouble(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Solo se permiten valores numéricos.");
                    continue;
                }

                if (valor< 0 || valor> 100) {
                    System.out.println("Error: El consumo debe estar entre 0 y 100%.");
                    continue;
                }

                if (!registros.add(valor)) {
                    System.out.println("Registro duplicado. Ya se ingresó ese valor.");
                    continue;
                }

                if (valor> 95) {
                    throw new ConsumoCriticoException("ALERTA: Consumo crítico detectado ("+valor + "%)");
                }
                System.out.println("Registro aceptado: " + valor + "%");
            }

        } catch (ConsumoCriticoException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner!= null) {
                scanner.close();
                System.out.println("Monitor detenido. Recursos cerrados.");
            }
        }
    }
}

