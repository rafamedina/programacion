package View;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;
import java.util.Scanner;

import Model.ClienteOtaku;
import Model.ProductoOtaku;

public class InterfazConsolaCliente {
    Scanner scanner = new Scanner(System.in);

    public int leerEntero(String mensaje) {
        // Leo un número entero desde consola, validando que sea positivo.
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                if (numero < 0) {
                    System.out.println("Debe ser un número entero positivo.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debes escribir un número entero.");
            }
        }
        return numero;
    }


    public int pedirId() {
        // Pido al usuario que ingrese un ID (entero positivo)
        return leerEntero("Dame un ID: ");
    }
    
    public String pedirCorreo() {
        // Pido al usuario un nombre de producto válido (no vacío)
        System.out.print("Dime el nombre: ");
        String nombre = scanner.nextLine().trim();

        if (nombre != null && !nombre.isEmpty()) {
            return nombre;
        } else {
            System.out.println("El nombre no puede estar vacío.");
            return pedirNombre();
        }
    }

    public String pedirEdicion() {
        // Pregunto qué campo desea editar el usuario (nombre, categoría, precio, etc.)
        String[] opcionesValidas = {"nombre", "email", "telefono", "todo"};
        String seleccion;

        System.out.println("¿Qué parte quieres modificar? (nombre, email, telefono, todo)");
        System.out.println("Escribe 'salir' para cancelar.");

        while (true) {
            System.out.print("Selecciona una opción: ");
            seleccion = scanner.nextLine().toLowerCase();

            if (seleccion.equals("salir")) {
                System.out.println("Edición cancelada.");
                return null;
            }

            for (String opcion : opcionesValidas) {
                if (opcion.equals(seleccion)) {
                    return seleccion;
                }
            }
            System.out.println("Opción no válida. Intenta de nuevo.");
        }
    }

    public String pedirNombre() {
        // Pido al usuario un nombre de producto válido (no vacío)
        System.out.print("Dime el nombre: ");
        String nombre = scanner.nextLine().trim();

        if (nombre != null && !nombre.isEmpty()) {
            return nombre;
        } else {
            System.out.println("El nombre no puede estar vacío.");
            return pedirNombre();
        }
    }

    public String pedirEmail() {
        // Pido al usuario una categoría válida (no vacía)
        System.out.print("Dime el Email: ");
        String email = scanner.nextLine().trim();

        if (email != null && !email.isEmpty()) {
            return email;
        } else {
            System.out.println("La email no puede estar vacío.");
            return pedirEmail();
        }
    }
    
    public String pedirTelefono() {
        // Pido al usuario una categoría válida (no vacía)
        System.out.print("Dime el Telefono: ");
        String tlf = scanner.nextLine().trim();

        if (tlf != null && !tlf.isEmpty()) {
            return tlf;
        } else {
            System.out.println("el Telefono no puede estar vacío.");
            return pedirTelefono();
        }
    }

    public Date pedirFecha() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setLenient(false); // Para que no se acepten fechas como 2023-02-30

        String fechaInput = "";
        boolean fechaValida = false;

        while (!fechaValida) {
            System.out.print("Dime la fecha (formato: YYYY-MM-DD): ");
            fechaInput = scanner.nextLine().trim();

            
            // Verificar que la fecha no esté vacía
            if (fechaInput.isEmpty()) {
                System.out.println("La fecha no puede estar vacía.");
            } else {
                try {
                    // Intentar parsear la fecha
                    formatoFecha.parse(fechaInput); // Esto lanza una excepción si la fecha es incorrecta
                    fechaValida = true; // Si se parsea correctamente, es válida
                } catch (ParseException e) {
                    System.out.println("La fecha ingresada no es válida. Inténtalo de nuevo.");
                }
            }
        }

        // Convertir la fecha a java.sql.Date antes de devolverla
        try {
            java.util.Date utilDate = formatoFecha.parse(fechaInput); // Convierte a Date de Java
            java.sql.Date fechaSQL = new Date(utilDate.getTime()); // Convierte a Date de SQL
            return fechaSQL; // Devuelve la fecha como java.sql.Date
        } catch (ParseException e) {
            return null; // Este caso no debería ocurrir gracias a la validación anterior
        }
    }


    public int eleccion() {
        // Pido una elección genérica del menú
        return leerEntero("Qué quieres hacer: ");
    }

    public ClienteOtaku pedirDatos() {
        // Recojo todos los datos del producto desde consola
        String nombre = pedirNombre();
        String email = pedirEmail();
        String tlf = pedirTelefono();
        return new ClienteOtaku(nombre, email, tlf);
    }

    public int MenuCliente() {
        // Muestro el menú principal del sistema
        System.out.println("-------Menú-------");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Buscar Cliente");
        System.out.println("3. Buscar Todos los Cliente");
        System.out.println("4. Actualizar un Cliente");
        System.out.println("5. Eliminar un Cliente");
        System.out.println("6. Buscar Producto por Email");
        System.out.println("7. Salir");
        int eleccion = eleccion();
        return eleccion;
    }

    public void mostrarMensaje(String mensaje) {
        // Imprimo cualquier mensaje en consola
        System.out.println(mensaje);
    }

    public void mostrarCliente(ClienteOtaku cliente) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(cliente.getFecha_registro());

        System.out.printf("ID: %d | NOMBRE: %-25s | EMAIL: %-20s | TELEFONO: %-15s | FECHA REGISTRO: %s\n",
                cliente.getId(),
                cliente.getNombre(),
                cliente.getEmail(),
                cliente.getTelefono(),
                fecha);
    }


    public void mostrarClientes(List<ClienteOtaku> lista) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.printf("%-5s | %-25s | %-20s | %-15s | %-15s\n",
                "ID", "NOMBRE", "EMAIL", "TELEFONO", "FECHA REGISTRO");
        System.out.println("------------------------------------------------------------------------------------");

        for (ClienteOtaku cliente : lista) {
            String fecha = sdf.format(cliente.getFecha_registro());

            System.out.printf("%-5d | %-25s | %-20s | %-15s | %-15s\n",
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getEmail(),
                    cliente.getTelefono(),
                    fecha);
        }
    }


}


