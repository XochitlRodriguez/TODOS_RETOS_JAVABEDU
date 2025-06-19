package reto2;

import java.util.Random;
import java.util.concurrent.*;

public class AeropuertoControl {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTrafico();
        CompletableFuture<Boolean> personalFuture = verificarPersonal();

        CompletableFuture<Void> resultadoFinal = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenRun(() -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();

                        System.out.println();
                        if (pista && clima && trafico && personal) {
                            System.out.println("🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("🚫 Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("🚨 Error al evaluar condiciones: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n🚨 Error en el proceso de verificación: " + ex.getMessage());
                    return null;
                });

        resultadoFinal.join();
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Verificando pista...");
            dormir(2);
            boolean disponible = probabilidad(80);
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌦️ Verificando clima...");
            dormir(3);
            boolean favorable = probabilidad(85);
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTrafico() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Verificando tráfico aéreo...");
            dormir(1);
            boolean libre = probabilidad(90);
            System.out.println("🚦 Tráfico aéreo despejado: " + libre);
            return libre;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonal() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("👷‍♂️ Verificando personal en tierra...");
            dormir(2);
            boolean disponible = probabilidad(95);
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        });
    }

    private static boolean probabilidad(int porcentajeExito) {
        return random.nextInt(100) < porcentajeExito;
    }

    private static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
