import misionespacial.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Callable<String>> sistemas = Arrays.asList(
                new SistemaNavegacion(),
                new SistemaSoporteVital(),
                new SistemaComunicaciones(),
                new SistemaControlTermico()
        );

        List<Future<String>> resultados = executor.invokeAll(sistemas);

        for (Future<String> resultado : resultados) {
            System.out.println(resultado.get());
        }

        executor.shutdown();
        System.out.println("✅ Todos los sistemas reportan estado operativo.");
    }
}
