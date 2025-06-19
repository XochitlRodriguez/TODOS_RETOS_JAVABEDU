import clinica.Encuesta;
import clinica.Sucursal;

import java.util.List;
import java.util.stream.Stream;

public class ProcesadorEncuestas {

    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Ana", "El tiempo de espera fue largo", 2),
                        new Encuesta("Luis", null, 5)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
                        new Encuesta("Pedro", null, 4)
                )),
                new Sucursal("Sur", List.of(
                        new Encuesta("Carlos", null, 2),
                        new Encuesta("Sofía", "No encontré el medicamento que necesitaba", 1)
                ))
        );

        System.out.println("📋 Seguimiento a pacientes insatisfechos:");

        sucursales.stream()
                .flatMap(sucursal -> generarSeguimientos(sucursal))
                .forEach(System.out::println);
    }

    private static Stream<String> generarSeguimientos(Sucursal sucursal) {
        return sucursal.getEncuestas().stream()
                .filter(e -> e.getCalificacion() <= 3)
                .flatMap(e -> e.getComentario()
                        .map(com -> Stream.of("Sucursal " + sucursal.getNombre() +
                                ": Seguimiento a paciente con comentario: \"" + com + "\""))
                        .orElseGet(Stream::empty)
                );
    }
}
