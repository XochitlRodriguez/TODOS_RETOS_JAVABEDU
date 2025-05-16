import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //CREO UN SALDO INICIAL CON VAR
        var saldo= 1000.0;
        int opcion;
        do {
            System.out.println("\nBienvenido al cajero automático");
            System.out.println("1.Consultar saldo");
            System.out.println("2.Depositar dinero");
            System.out.println("3.Retirar dinero");
            System.out.println("4.Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            //PROCEDIMIENTO DE LAS VARIABLES UTILIZADAS
            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + saldo);
                    break;

                case 2:
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    saldo += deposito;
                    System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;

                case 3:
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro <= saldo) {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Fondos insuficientes. No se pudo realizar el retiro.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Gracias por usar el cajero automático. ¡Hasta pronto!");
                    break;

                    //AQUI SE CONSIDERA EL DESAFÍO ADICIONAL
                default:
                    System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
                    continue; // Vuelve a mostrar el menú sin terminar el programa
            }

        } while (opcion != 4);

        scanner.close();
    }
}
