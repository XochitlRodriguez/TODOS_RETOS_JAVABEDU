package Reto1;

import java.util.*;

public class GestionOrdenes {

    // Método generico
    public static void mostrarOrdenes(List<? extends OrdenProduccion> ordenes) {
        System.out.println("Listado de órdenes:");
        ordenes.forEach(OrdenProduccion::mostrarResumen);
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> ordenes, int costoExtra) {
        System.out.println("Aplicando costo adicional a órdenes personalizadas...");
        for (Object obj : ordenes) {
            if (obj instanceof OrdenPersonalizada personalizada) {
                System.out.printf("Orden %s procesada con un cargo adicional de $%d%n",
                        personalizada.getCodigo(), costoExtra);
            }
        }
    }

    // Desafío opcional: contar por tipo de orden
    public static void contarOrdenes(List<? extends OrdenProduccion> ordenes) {
        int totalMasas = 0, totalPersonalizadas = 0, totalPrototipos = 0;

        for (OrdenProduccion o : ordenes) {
            if (o instanceof OrdenMasa) totalMasas++;
            else if (o instanceof OrdenPersonalizada) totalPersonalizadas++;
            else if (o instanceof OrdenPrototipo) totalPrototipos++;
        }

        System.out.println("Estadísticas de producción:");
        System.out.printf("🔧 Producción en masa: %d%n", totalMasas);
        System.out.printf("🛠️ Personalizadas: %d%n", totalPersonalizadas);
        System.out.printf("🧪 Prototipos: %d%n", totalPrototipos);
    }

    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = List.of(
                new OrdenMasa("M001", 300),
                new OrdenMasa("M002", 450)
        );

        List<OrdenPersonalizada> ordenesPersonalizadas = List.of(
                new OrdenPersonalizada("C001", 120, "Acme Corp"),
                new OrdenPersonalizada("C002", 90, "Beta Ltd")
        );

        List<OrdenPrototipo> ordenesPrototipo = List.of(
                new OrdenPrototipo("T001", 10, "Inicial"),
                new OrdenPrototipo("T002", 6, "Validación")
        );

        // Lista combinada
        List<OrdenProduccion> todas = new ArrayList<>();
        todas.addAll(ordenesMasa);
        todas.addAll(ordenesPersonalizadas);
        todas.addAll(ordenesPrototipo);

        // Ejecutar funcionalidades
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);

        procesarPersonalizadas(ordenesPersonalizadas, 150);
        contarOrdenes(todas);
    }
}
