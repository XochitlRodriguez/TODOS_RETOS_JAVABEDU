package Reto1;

import java.util.Objects;

public class Factura {
    private String folio;
    private String cliente;
    private double total;

    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    //usamos el override para sobreescribir nuestro metodo heredado

    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this== obj) return true;
        if (obj== null ||getClass()!=obj.getClass()) return false;
        Factura factura=(Factura) obj;
        return folio.equals(factura.folio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }
}
