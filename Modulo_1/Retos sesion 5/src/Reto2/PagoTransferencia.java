package Reto2;

public class PagoTransferencia extends MetodoPago implements Autenticable {
    private boolean validacionExternaExitosa;

    public PagoTransferencia(double monto, boolean validacionExternaExitosa) {
        super(monto);
        this.validacionExternaExitosa=validacionExternaExitosa;
    }

    @Override
    public boolean autenticar() {
        return validacionExternaExitosa;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago por transferencia de $"+monto);
    }
}


