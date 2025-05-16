package Reto1;

import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    @Override
    public String obtenerDecision() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("¿Qué debería hacer el héroe?");
        System.out.println("A - Entrar al bosque");
        System.out.println("B - Volver al pueblo");
        System.out.print("Tu elección: ");
        String decision= scanner.nextLine();
        return decision.trim().toUpperCase();
    }
}

