package Reto1;

public class MainNarrativa {
    public static void main(String[] args) {

        //PROCESOS
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();
        TransicionHistoria transicion = new TransicionSimple();

        dialogo.mostrarDialogo("Narrador", "El héroe se encuentra en una encrucijada.");
        dialogo.mostrarDialogo("Héroe", "Tengo que decidir rápido qué hacer...");

        String eleccion = decision.obtenerDecision();
        transicion.siguienteEscena(eleccion);

        dialogo.mostrarDialogo("Narrador", "Y así continúa la historia...");
    }
}
