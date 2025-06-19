package hospital;

public class ProfesionalMedico implements Runnable {
    private final String nombre;
    private final RecursoHospitalario recurso;

    public ProfesionalMedico(String nombre, RecursoHospitalario recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.acceder(nombre);
    }
}
