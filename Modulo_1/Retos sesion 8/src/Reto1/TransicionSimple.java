package Reto1;

public class TransicionSimple implements TransicionHistoria {
    @Override
    public void siguienteEscena(String decision) {
        if (decision.equalsIgnoreCase("A")) {
            System.out.println("El héroe entra en el bosque oscuro...");
        } else {
            System.out.println("El héroe regresa al pueblo en busca de ayuda...");
        }
    }
}

