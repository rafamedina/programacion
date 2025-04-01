package ejercicio77;
import java.util.HashMap;

public class Producto {
    HashMap<String, Double> lista = new HashMap<>();

    public void añadirLista(String nombre, double precio) {
        lista.put(nombre, precio);
    }

    public void mostrarProductosMayoresA50() {
        lista.forEach((nombre, precio) -> {
            if (precio > 50) System.out.println(nombre + "->" + precio + "€");
        });
    }}