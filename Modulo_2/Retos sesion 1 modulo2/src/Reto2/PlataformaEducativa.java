package Reto2;

import java.util.*;
import java.util.function.Predicate;

public class PlataformaEducativa {

    public static void mostrarMateriales(List<? extends MaterialCurso> materiales) {
        System.out.println("\n📚 Listado de materiales del curso:");
        materiales.forEach(MaterialCurso::mostrarDetalle);
    }

    public static void contarDuracionVideos(List<? extends Video> videos) {
        int duracionTotal = videos.stream().mapToInt(Video::getDuracion).sum();
        System.out.println("\n🎥 Duración total de videos: " + duracionTotal + " minutos");
    }

    public static void marcarEjerciciosRevisados(List<? super Ejercicio> materiales) {
        System.out.println();
        for (Object obj : materiales) {
            if (obj instanceof Ejercicio ejercicio) {
                ejercicio.setRevisado(true);
                System.out.printf("✅ Ejercicio '%s' marcado como revisado.%n", ejercicio.getTitulo());
            }
        }
    }


    public static void filtrarPorAutor(List<? extends MaterialCurso> materiales, Predicate<MaterialCurso> criterio) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        materiales.stream()
                .filter(criterio)
                .forEach(MaterialCurso::mostrarDetalle);
    }

    public static void main(String[] args) {
        List<MaterialCurso> materiales = List.of(
                new Video("Introducción a Java", "Mario", 15),
                new Video("POO en Java", "Carlos", 20),
                new Articulo("Historia de Java", "Ana", 1200),
                new Articulo("Tipos de datos", "Luis", 800),
                new Ejercicio("Variables y tipos", "Luis"),
                new Ejercicio("Condicionales", "Mario")
        );

        // Separar por tipo usando instanceof
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();

        for (MaterialCurso m : materiales) {
            if (m instanceof Video v) videos.add(v);
            else if (m instanceof Ejercicio e) ejercicios.add(e);
        }

        mostrarMateriales(materiales);
        contarDuracionVideos(videos);
        marcarEjerciciosRevisados(ejercicios);
        filtrarPorAutor(materiales, m -> m.getAutor().equalsIgnoreCase("Mario"));
    }
}
