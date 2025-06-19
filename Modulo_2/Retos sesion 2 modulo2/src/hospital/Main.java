import hospital.ProfesionalMedico;
import hospital.RecursoHospitalario;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a recursos hospitalarios...");

        // Creamos un recurso exclusivo
        RecursoHospitalario quirófano = new RecursoHospitalario("Quirófano 1");

        // Creamos un pool de 4 hilos (representando concurrencia)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Ejecutamos tareas (profesionales intentando usar el quirófano)
        executor.execute(new ProfesionalMedico("Dra. Martínez", quirófano));
        executor.execute(new ProfesionalMedico("Dr. Herrera", quirófano));
        executor.execute(new ProfesionalMedico("Enfermero Silva", quirófano));
        executor.execute(new ProfesionalMedico("Dra. Rivera", quirófano));

        executor.shutdown(); // Ya no se aceptan más tareas
    }
}
