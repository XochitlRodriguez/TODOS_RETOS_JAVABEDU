package Reto1;

public class main {
    public static void main(String[] args) {
        Factura f1=new Factura("FAC001","Juan Pérez", 1450.0);
        Factura f2=new Factura("FAC001","Comercial XYZ", 1450.0);

        System.out.println(f1.toString());
        System.out.println(f2.toString());

        System.out.println("¿Las facturas son iguales?:" + f1.equals(f2));
    }
}

