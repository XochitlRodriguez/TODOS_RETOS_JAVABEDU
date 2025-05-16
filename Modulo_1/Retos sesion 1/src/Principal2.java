public class Principal2 {
    public static void main(String[] args) {
        //Objetos
        Entrada entrada1 = new Entrada("Obra de Teatro", 100.0);
        Entrada entrada2 = new Entrada("Tamborileros de Tabasco", 300.0);
        Entrada entrada3 = new Entrada( "Rivera Maya", 350);

        // Resultados
        entrada1.mostrarInformacion();
        entrada2.mostrarInformacion();
        entrada3.mostrarInformacion();
    }
}

