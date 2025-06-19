package Reto2;

public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor) {
        super(titulo, autor);
        this.revisado = false;
    }

    public boolean isRevisado() {
        return revisado;
    }

    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.printf("📝 Ejercicio: %s - Autor: %s - Revisado: %b%n",
                getTitulo(), getAutor(), revisado);
    }
}

