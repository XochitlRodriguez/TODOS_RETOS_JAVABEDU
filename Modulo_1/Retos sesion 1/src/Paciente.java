public class Paciente {
    // Atributos
    String nombre;
    int edad;
    String numerodeExpediente;


    // Métodos
    public void mostrarInformacion() {
        System.out.print("Paciente: " + nombre);
        System.out.print("Edad:" + edad);
        System.out.print("Número de expediente: " + numerodeExpediente);
    }

}
