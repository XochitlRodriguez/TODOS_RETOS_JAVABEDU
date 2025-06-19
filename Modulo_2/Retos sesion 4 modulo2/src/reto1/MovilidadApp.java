import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    public static void main(String[] args) {
        System.out.println("🚦 Iniciando simulación de viaje...\n");

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        // Combina los resultados de ambas tareas cuando ambas se completen
        CompletableFuture<Void> confirmacionViaje = rutaFuture
                .thenCombine(tarifaFuture, MovilidadApp::formarMensaje)
                .thenAccept(mensaje -> System.out.println("✅ " + mensaje))
                .exceptionally(error -> {
                    System.out.println("🚨 Error durante el proceso: " + error.getMessage());
                    return null;
                });

        // Esperamos que el flujo termine antes de salir del programa
        confirmacionViaje.join();
    }

    // 🗺️ Simulación del cálculo de ruta
    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🗺️ Calculando ruta...");
            dormir(3);
            return "Centro → Norte";
        });
    }

    // 💰 Simulación de la estimación de tarifa
    public static CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            dormir(2);
            return 75.50;
        });
    }

    // 🧩 Construcción del mensaje combinado
    private static String formarMensaje(String ruta, Double tarifa) {
        return "🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa;
    }

    // 💤 Utilidad para simular latencia
    private static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
