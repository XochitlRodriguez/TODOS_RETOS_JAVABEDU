package Reto2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

public class TemarioEducativo {
    public static void main(String[] args) {
        //Lista de temas activos
        CopyOnWriteArrayList<Tema> temas= new CopyOnWriteArrayList<>();

        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));

        //repositorio
        ConcurrentHashMap<String, String> recursos= new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/ambiente");

        //Temas ordenados alfabéticamente
        System.out.println("Temas ordenados por título:");
        Collections.sort(temas);
        for (Tema tema: temas) {
            System.out.println(tema);
        }

        //Temas de prioridad 1 al 3
        System.out.println("Temas ordenados por prioridad:");
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        for (Tema tema: temas) {
            System.out.println(tema);
        }

        System.out.println("Recursos compartidos por tema:");
        for (String titulo : recursos.keySet()) {
            System.out.println("- " +titulo+ " → " +recursos.get(titulo));
        }
    }
}

