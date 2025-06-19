package Reto1;

public class OrdenPrototipo extends OrdenProduccion {
    private final String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    public String getFaseDesarrollo() {
        return faseDesarrollo;
    }

    @Override
    public void mostrarResumen() {
        System.out.printf("🧪 OrdenPrototipo - Código: %s - Cantidad: %d - Fase: %s%n",
                getCodigo(), getCantidad(), faseDesarrollo);
    }
}
