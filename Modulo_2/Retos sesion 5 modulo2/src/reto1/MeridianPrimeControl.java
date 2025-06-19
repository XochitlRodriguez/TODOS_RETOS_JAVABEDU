package reto1;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class MeridianPrimeControl {

    private static final Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🔧 Sistema de monitoreo activado para Meridian Prime...\n");


        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(congestion -> congestion > 70)
                .map(congestion -> "🚗 Alerta: Congestión del " + congestion + "% en Avenida Solar")
                .doOnNext(System.out::println)
                .onBackpressureBuffer(5);


        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(80))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .doOnNext(System.out::println);


        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] niveles = {"Baja", "Media", "Alta"};
                    return niveles[random.nextInt(niveles.length)];
                })
                .filter(prioridad -> prioridad.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad " + p)
                .doOnNext(System.out::println);


        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(retraso -> retraso > 5)
                .map(retraso -> "🚝 Tren maglev con retraso crítico: " + retraso + " minutos")
                .doOnNext(System.out::println)
                .onBackpressureBuffer(3);


        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    return estados[random.nextInt(estados.length)];
                })
                .transform(MeridianPrimeControl::controlarSemaforos);


        Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .bufferTimeout(5, Duration.ofSeconds(2)) // Agrupamos eventos cada 2 segundos
                .filter(lista -> lista.size() >= 3)
                .doOnNext(lista -> System.out.println("🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime\n"))
                .subscribe();


        Thread.sleep(15000);
    }

    private static Flux<String> controlarSemaforos(Flux<String> flujo) {
        final int[] rojos = {0};
        return flujo
                .filter(estado -> {
                    if (estado.equals("Rojo")) {
                        rojos[0]++;
                        if (rojos[0] >= 3) {
                            rojos[0] = 0;
                            return true;
                        }
                    } else {
                        rojos[0] = 0;
                    }
                    return false;
                })
                .map(r -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte")
                .doOnNext(System.out::println);
    }
}
