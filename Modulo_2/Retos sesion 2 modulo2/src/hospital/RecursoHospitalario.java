package hospital;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoHospitalario {

    private final String nombreRecurso;
    private final ReentrantLock acceso = new ReentrantLock();

    public RecursoHospitalario(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public void acceder(String profesional) {
        acceso.lock(); // 🚪 Solicita acceso exclusivo
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombreRecurso);
            Thread.sleep(1000); // ⏳ Simula tiempo de uso
            System.out.println("✅ " + profesional + " ha salido de " + nombreRecurso);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            acceso.unlock(); // 🔓 Libera el recurso
        }
    }
}
