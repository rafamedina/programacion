package View;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import Model.ProductoOtaku;

public class InterfazProducto extends JFrame {
Scanner scanner = new Scanner(System.in);

JTextArea inputFieldsalida = new JTextArea();
String datoRecogido = "";
private JTable tablaProductos;
private DefaultTableModel modeloTablaProductos;
	
	public Component createFieldSalida() {

		 	inputFieldsalida.setEditable(false);  // No editable
		    inputFieldsalida.setWrapStyleWord(true);  // Para que las palabras no se corten
		    inputFieldsalida.setLineWrap(true);  // Permitir que el texto se ajuste a las líneas

		    JScrollPane scroll = new JScrollPane(inputFieldsalida);  // Añadir un JScrollPane para el desplazamiento
		    scroll.setBounds(150, 515, 475, 180);  // Definir el tamaño y la ubicación

		    return scroll;
	}
	public JScrollPane crearTablaProductos() {
	    modeloTablaProductos = new DefaultTableModel();
	    modeloTablaProductos.setColumnIdentifiers(new String[]{"ID", "NOMBRE", "CATEGORIA", "PRECIO (€)", "STOCK"});

	    tablaProductos = new JTable(modeloTablaProductos);
	    tablaProductos.setEnabled(false); // Solo visualización

	    JScrollPane scrollTabla = new JScrollPane(tablaProductos);
	    scrollTabla.setBounds(25, 255, 730, 250);
	    return scrollTabla;
	}

	 // Mostrar un mensaje en inputFieldsalida
    public void mostrarMensaje(String mensaje) {
        inputFieldsalida.setText(mensaje);  // Poner el mensaje en el campo de salida
    }

    // Métodos para capturar datos
    public int leerEntero(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(this, mensaje);
            if (entrada == null) {
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
                return -1;
            }
            try {
                int numero = Integer.parseInt(entrada);
                if (numero < 0) {
                    JOptionPane.showMessageDialog(this, "El número debe ser positivo.");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debes introducir un número entero válido.");
            }
        }
    }


    public double leerDecimal(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(this, mensaje);
            if (entrada == null) {
                JOptionPane.showMessageDialog(this, "Operación cancelada.");
                return -1;
            }
            try {
                double numero = Double.parseDouble(entrada);
                if (numero < 0) {
                    JOptionPane.showMessageDialog(this, "El número debe ser positivo.");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Debes introducir un número decimal válido.");
            }
        }
    }



    // Métodos para pedir datos del producto




    public int pedirStock() {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(this, "¿Qué stock nuevo quieres poner?");
                if (entrada == null) {
                    JOptionPane.showMessageDialog(this, "Operación cancelada.");
                    return -1;
                }
                int stock = Integer.parseInt(entrada);
                if (stock < 0) {
                    JOptionPane.showMessageDialog(this, "El stock no puede ser negativo.");
                } else {
                    return stock;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Introduce un número válido para el stock.");
            }
        }
    }

    
    
    public String pedirNombre() {
        return pedirCampo("Dime el nombre:");
    }

    public String pedirCategoria() {
        return pedirCampo("Dime la categoria:");
    }

    public Double pedirPrecio() {
        return leerDecimal("Dime el precio:");
    }

    public int pedirId() {
        return leerEntero("Dame un ID:");
    }

    public String pedirCampo(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(this, mensaje);
            if (valor != null && !valor.trim().isEmpty()) {
                return valor.trim();
            } else {
                JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
            }
        }
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
    	 modeloTablaProductos.setRowCount(0); // Limpiar tabla

    	    modeloTablaProductos.addRow(new Object[]{
    	        producto.getId(),
    	        producto.getNombre(),
    	        producto.getCategoria(),
    	        String.format("%.2f", producto.getPrecio()) + " €",
    	        producto.getStock()
    	    });
    }

    public void mostrarProductos(List<ProductoOtaku> lista) {
    	 modeloTablaProductos.setRowCount(0); // Limpiar tabla

    	    for (ProductoOtaku producto : lista) {
    	        modeloTablaProductos.addRow(new Object[]{
    	            producto.getId(),
    	            producto.getNombre(),
    	            producto.getCategoria(),
    	            String.format("%.2f", producto.getPrecio()) + " €",
    	            producto.getStock()
    	        });
    	    }
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
