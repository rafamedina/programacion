package ejercicio40;
import java.util.ArrayList;

class Tienda {
    private ArrayList<Producto> productos;


    public Tienda() {
        productos = new ArrayList<>();
    }


    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Productos disponibles:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }
}