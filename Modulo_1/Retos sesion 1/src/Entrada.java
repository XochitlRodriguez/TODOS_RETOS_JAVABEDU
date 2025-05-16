public class Entrada {
    // Atributos
    String NombreEvento;
    double PrecioEntrada;

    //Constructor
    public Entrada (String NombreEvento, double PrecioEntrada) {
        this.NombreEvento = NombreEvento;
        this.PrecioEntrada = PrecioEntrada;
    }

    // Métodos
    public void mostrarInformacion() {
        System.out.print("Evento:" + NombreEvento + "| Precio:" + PrecioEntrada);
    }
}
