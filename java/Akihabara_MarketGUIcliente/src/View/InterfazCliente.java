package View;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Model.ClienteOtaku;

public class InterfazCliente extends JFrame {
    JTextArea campoSalida = new JTextArea();

    public Component crearCampoSalida() {
        campoSalida.setEditable(false);
        campoSalida.setWrapStyleWord(true);
        campoSalida.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(campoSalida);
        scroll.setBounds(5, 250, 475, 180);

        return scroll;
    }

    public void mostrarMensaje(String mensaje) {
        campoSalida.setText(mensaje);
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(this, mensaje);
                if (entrada == null) return -1; // por si se cancela
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida. Debes escribir un número entero.");
            }
        }
    }

    public String pedirNombre() {
        return pedirCampo("Dime el nombre:");
    }

    public String pedirEmail() {
        return pedirCampo("Dime el email:");
    }

    public String pedirTelefono() {
        return pedirCampo("Dime el teléfono:");
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

    public Date pedirFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.setLenient(false);

        while (true) {
            String entrada = JOptionPane.showInputDialog(this, "Dime la fecha (YYYY-MM-DD):");
            if (entrada == null || entrada.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "La fecha no puede estar vacía.");
                continue;
            }
            try {
                java.util.Date utilDate = formato.parse(entrada);
                return new Date(utilDate.getTime());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Fecha no válida. Intenta de nuevo.");
            }
        }
    }

    public String pedirEdicion() {
        String[] opciones = {"nombre", "email", "telefono", "todo"};
        while (true) {
            String seleccion = JOptionPane.showInputDialog(this, "¿Qué parte quieres modificar? (nombre, email, telefono, todo)\nEscribe 'salir' para cancelar.");
            if (seleccion == null || seleccion.equalsIgnoreCase("salir")) {
                mostrarMensaje("Edición cancelada.");
                return null;
            }
            for (String opcion : opciones) {
                if (opcion.equalsIgnoreCase(seleccion)) {
                    return opcion;
                }
            }
            JOptionPane.showMessageDialog(this, "Opción no válida. Intenta de nuevo.");
        }
    }

    public ClienteOtaku pedirDatos() {
        String nombre = pedirNombre();
        String email = pedirEmail();
        String telefono = pedirTelefono();
        return new ClienteOtaku(nombre, email, telefono);
    }

    public void mostrarCliente(ClienteOtaku cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(cliente.getFecha_registro());

        String mensaje = String.format("ID: %d | NOMBRE: %-25s | EMAIL: %-20s | TELEFONO: %-15s | FECHA REGISTRO: %s",
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                fecha);
        mostrarMensaje(mensaje);
    }

    public void mostrarClientes(List<ClienteOtaku> lista) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder mensaje = new StringBuilder(String.format("%-5s | %-25s | %-20s | %-15s | %-15s\n",
                "ID", "NOMBRE", "EMAIL", "TELEFONO", "FECHA REGISTRO"));
        mensaje.append("------------------------------------------------------------------------------------\n");

        for (ClienteOtaku cliente : lista) {
            String fecha = sdf.format(cliente.getFecha_registro());
            mensaje.append(String.format("%-5d | %-25s | %-20s | %-15s | %-15s\n",
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getEmail(),
                    cliente.getTelefono(),
                    fecha));
        }

        mostrarMensaje(mensaje.toString());
    }

   
}



