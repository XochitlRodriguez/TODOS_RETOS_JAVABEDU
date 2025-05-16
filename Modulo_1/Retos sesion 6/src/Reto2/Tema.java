package Reto2;

public class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    public Tema(String titulo, int prioridad) {
        this.titulo= titulo;
        this.prioridad= prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);

    }

    @Override
    public String toString() {
        return "Tema: "+titulo+ " | Prioridad: "+prioridad;
    }
}

