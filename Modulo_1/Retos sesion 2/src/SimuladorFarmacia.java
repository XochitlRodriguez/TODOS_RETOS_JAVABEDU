import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.print("Nombre del medicamento: ");
        String nombre= scanner.nextLine();

        System.out.print("Cantidad de piezas: ");
        int cantidad= scanner.nextInt();

        System.out.print("Precio unitario: ");
        double precio= scanner.nextDouble();
        double totalSinDescuento= precio *cantidad;

        //Descuento con operador ternario

        boolean aplicaDescuento= totalSinDescuento >500;
        var descuento= aplicaDescuento ? totalSinDescuento * 0.15: 0.0;
        double totalAPagar= totalSinDescuento - descuento;

        System.out.println("   Resumen de compra   ");
        System.out.println("Medicamento: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalAPagar);

        scanner.close();
    }


}