package Reto1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroMuestras {
    public static void main(String[] args) {
        //Array de las listas
        ArrayList<String> ordenLlegada=new ArrayList<>();
        ordenLlegada.add("Homo sapiens");
        ordenLlegada.add("Mus musculus");
        ordenLlegada.add("Arabidopsis thaliana");
        ordenLlegada.add("Homo sapiens"); // muestra repetida

        //HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas= new HashSet<>(ordenLlegada);

        //HashMap para asociar ID de muestra con investigador
        HashMap<String, String> muestraInvestigador= new HashMap<>();
        muestraInvestigador.put("M-001", "Dra.López");
        muestraInvestigador.put("M-002", "Dr.Hernández");
        muestraInvestigador.put("M-003", "Dra.Pérez");

        System.out.println("Orden de llegada de muestras:");
        for (String especie: ordenLlegada) {
            System.out.println("- " + especie);
        }

        //especies únicas procesadas
        System.out.println("Especies únicas procesadas:");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }

        //relación ID→Investigador
        System.out.println("Relación ID de muestra → Investigador:");
        for (String id : muestraInvestigador.keySet()) {
            System.out.println(id + " → " + muestraInvestigador.get(id));
        }

        //esto es para buscar un ID específico
        Scanner scanner=new Scanner(System.in);
        System.out.print("Ingrese un ID de muestra para buscar (ej. M-002): ");
        String idBusqueda=scanner.nextLine();

        if (muestraInvestigador.containsKey(idBusqueda)) {
            System.out.println("Resultado: "+idBusqueda+" → "+ muestraInvestigador.get(idBusqueda));
        } else {
            System.out.println("ID no encontrado en el registro.");
        }

        scanner.close();
    }
}

