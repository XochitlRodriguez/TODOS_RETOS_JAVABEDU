package Reto1;

public class Principal {
    public static void main(String[] args) {
        Pasajero p1 = new Pasajero("Ana Martínez", "A123456");
        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");

        if (vuelo.reservarAsiento(p1)) {
            System.out.println("Reserva realizada con éxito");
        }

        System.out.println();
        System.out.println(vuelo.obtenerItinerario());

        System.out.println("Cancelando reserva");
        vuelo.cancelarReserva();

        System.out.println();
        System.out.println(vuelo.obtenerItinerario());

        System.out.println();
        if (vuelo.reservarAsiento("Mario Gonzalez", "M654321")) {
            System.out.println("Reserva realizada con éxito");
        }

        System.out.println();
        System.out.println(vuelo.obtenerItinerario());
    }
}
