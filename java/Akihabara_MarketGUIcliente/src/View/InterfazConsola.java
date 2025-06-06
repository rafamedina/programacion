package View;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import Model.ProductoOtaku;

public class InterfazConsola extends JFrame {
Scanner scanner = new Scanner(System.in);

JTextArea inputFieldsalida = new JTextArea();
String datoRecogido = "";

	
	public Component createFieldSalida() {

		 	inputFieldsalida.setEditable(false);  // No editable
		    inputFieldsalida.setWrapStyleWord(true);  // Para que las palabras no se corten
		    inputFieldsalida.setLineWrap(true);  // Permitir que el texto se ajuste a las líneas

		    JScrollPane scroll = new JScrollPane(inputFieldsalida);  // Añadir un JScrollPane para el desplazamiento
		    scroll.setBounds(5, 250, 375, 180);  // Definir el tamaño y la ubicación

		    return scroll;
	}
	
	 // Mostrar un mensaje en inputFieldsalida
    public void mostrarMensaje(String mensaje) {
        inputFieldsalida.setText(mensaje);  // Poner el mensaje en el campo de salida
    }

    // Métodos para capturar datos
    public int leerEntero(String mensaje) {
        String entrada = JOptionPane.showInputDialog(this, mensaje);  // Pedir entrada por cuadro de diálogo
        return Integer.parseInt(entrada);  // Convertir a entero
    }

    public double leerDecimal(String mensaje) {
        String entrada = JOptionPane.showInputDialog(this, mensaje);  // Pedir entrada por cuadro de diálogo
        return Double.parseDouble(entrada);  // Convertir a decimal
    }

    public String obtenerDatoRecogido() {
        return datoRecogido;  // Retornar el dato recogido
    }

    // Métodos para pedir datos del producto
    public String pedirNombre() {
        return JOptionPane.showInputDialog(this, "Dime el nombre:");
    }

    public String pedirCategoria() {
        return JOptionPane.showInputDialog(this, "Dime la categoría:");
    }

    public double pedirPrecio() {
        return leerDecimal("¿Qué precio nuevo quieres poner?");
    }

    public int pedirStock() {
        return leerEntero("¿Qué stock nuevo quieres poner?");
    }
    
    public int pedirId() {
        return leerEntero("Dime un ID: ");
    }
    
    // Pedir datos completos del producto
    public ProductoOtaku pedirDatos() {
        String nombre = pedirNombre();
        String categoria = pedirCategoria();
        double precio = pedirPrecio();
        int stock = pedirStock();
        return new ProductoOtaku(nombre, categoria, precio, stock);
    }
    public void mostrarProducto(ProductoOtaku producto) {
        String mensaje = String.format("ID: %-5d | NOMBRE: %-25s | CATEGORIA: %-10s | PRECIO: %10.2f € | STOCK: %-5d\n",
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getStock());
        mostrarMensaje(mensaje);  // Mostrar los detalles del producto en el JTextArea
    }

    public void mostrarProductos(List<ProductoOtaku> lista) {
        StringBuilder mensaje = new StringBuilder(String.format("%-5s | %-25s | %-10s | %-10s | %-5s\n", 
                                                              "ID", "NOMBRE", "CATEGORIA", "PRECIO", "STOCK"));
        mensaje.append("----------------------------------------------------------------------\n");

        for (ProductoOtaku producto : lista) {
            mensaje.append(String.format("%-5d | %-25s | %-10s | %10.2f € | %-5d\n",
                    producto.getId(),
                    producto.getNombre(),
                    producto.getCategoria(),
                    producto.getPrecio(),
                    producto.getStock()));
        }

        mostrarMensaje(mensaje.toString());  // Mostrar toda la lista de productos en el JTextArea
    }

    public String pedirEdicion() {
        String[] opcionesValidas = {"nombre", "categoria", "precio", "stock", "todo"};
        String seleccion;

        while (true) {
            seleccion = JOptionPane.showInputDialog(this,
                    "¿Qué parte quieres modificar? (nombre, categoria, precio, stock, todo) Escribe 'salir' para cancelar.");
            if (seleccion == null || seleccion.equals("salir")) {
                mostrarMensaje("Edición cancelada.");
                return null;
            }

            for (String opcion : opcionesValidas) {
                if (opcion.equals(seleccion)) {
                    return seleccion;
                }
            }

            mostrarMensaje("Opción no válida. Intenta de nuevo.");
        }
    }
}
