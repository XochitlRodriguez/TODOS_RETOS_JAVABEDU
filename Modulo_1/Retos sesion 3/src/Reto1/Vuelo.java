package Reto1;

public class Vuelo{
    //Escribo los atributos solicitados
    private final String codigoVuelo;
    private String destino;
    private String horaSalida;
    private Pasajero asientoReservado;

    //Metodo
    public Vuelo(String codigoVuelo, String destino, String horaSalida) {
        this.codigoVuelo=codigoVuelo;
        this.destino=destino;
        this.horaSalida=horaSalida;
        this.asientoReservado=null;
    }

    public boolean reservarAsiento(Pasajero p) {
        if (asientoReservado == null) {
            asientoReservado = p;
            return true;
        }
        return false;
    }

    public boolean reservarAsiento(String nombre, String pasaporte) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        }
        return false;
    }

    public void cancelarReserva() {
        asientoReservado = null;
    }

    public String obtenerItinerario() {
        String info = "Itinerario del vuelo:\n" +
                "Código: " + codigoVuelo + "\n" +
                "Destino: " + destino + "\n" +
                "Salida: " + horaSalida + "\n" +
                "Pasajero: " + (asientoReservado != null ? asientoReservado.getNombre() : "[Sin reserva]");
        return info;
    }
}