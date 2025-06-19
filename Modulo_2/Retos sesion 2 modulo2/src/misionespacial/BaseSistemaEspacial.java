package misionespacial;

import java.util.concurrent.Callable;

// Clase base para evitar repetición de lógica común (opcional pero útil)
public abstract class BaseSistemaEspacial implements Callable<String> {
    private final String nombreSistema;
    private final int tiempoSimulacion;

    public BaseSistemaEspacial(String nombreSistema, int tiempoSimulacion) {
        this.nombreSistema = nombreSistema;
        this.tiempoSimulacion = tiempoSimulacion;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(tiempoSimulacion);
        return nombreSistema;
    }
}

