package Reto2;

public class Principal {
    public static void main(String[] args) {
        Factura facturaConRFC = new Factura(2500.0, "Servicio de consultoría", "ABCC010101XYZ");
        Factura facturaSinRFC = new Factura(1800.0, "Reparación de equipo", null);

        System.out.println(facturaConRFC.getResumen());
        System.out.println();
        System.out.println(facturaSinRFC.getResumen());
    }
}

