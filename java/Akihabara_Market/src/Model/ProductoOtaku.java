package Model;

public class ProductoOtaku {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    // Este constructor lo uso cuando voy a crear un nuevo producto que aún no tiene ID (el ID se asignará en la base de datos)
    public ProductoOtaku(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Este constructor lo uso cuando ya conozco el ID del producto (por ejemplo, al leer desde la base de datos)
    public ProductoOtaku(int id, String nombre, String categoria, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor vacío. Lo uso cuando necesito crear un objeto sin valores iniciales.
    public ProductoOtaku() {
    }

    // Métodos getter y setter para acceder y modificar cada campo del producto

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}


















