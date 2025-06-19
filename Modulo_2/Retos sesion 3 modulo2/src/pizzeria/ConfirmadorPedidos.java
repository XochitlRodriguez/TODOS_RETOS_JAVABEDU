import pizzeria.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConfirmadorPedidos {

    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Juan", "domicilio", "555-1234"),
                new Pedido("María", "local", null),
                new Pedido("Carlos", "domicilio", null),
                new Pedido("Luisa", "domicilio", "555-5678"),
                new Pedido("Ana", "local", "555-9999")
        );

        List<String> confirmaciones = pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream) // equivalente a filter+get
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                .collect(Collectors.toList());

        System.out.println("📞 Confirmaciones de pedidos a domicilio:");
        confirmaciones.forEach(System.out::println);
    }
}
