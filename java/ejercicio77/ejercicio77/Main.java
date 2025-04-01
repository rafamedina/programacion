package ejercicio77;

public class Main {

    public static void main(String[] args) {
        Producto productos = new Producto();
        productos.añadirLista("Laptop", 700.0);
        productos.añadirLista("Mouse", 25.0);
        productos.añadirLista("Teclado", 55.0);
        productos.añadirLista("Monitor", 150.0);
        productos.mostrarProductosMayoresA50();
    }
}



