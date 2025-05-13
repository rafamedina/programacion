import java.util.Scanner;
import java.sql.Connection;

public class Vista {
    Scanner scanner = new Scanner(System.in);
    Connection conexion = Conexion.conectar();

    public int eleccion() {
        int eleccion;
        System.out.print("SELECCIONA UNA OPCIÓN: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingresa un número válido.");
            scanner.next();  // Limpiar la entrada no válida
        }
        eleccion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer
        return eleccion;
    }

    public void menuCliente() {
        Clientes cliente = new Clientes("","",0);
        int eleccion = 0;

        do {
            // Menú principal
            System.out.println("----- MENÚ CLIENTE -----");
            System.out.println("1 – AÑADIR CLIENTES");
            System.out.println("2 – LISTAR CLIENTES");
            System.out.println("3 – EDITAR CLIENTES");
            System.out.println("4 – ELIMINAR CLIENTES");
            System.out.println("5 – SALIR");

            // Solicitar opción
            eleccion = eleccion();

            switch (eleccion) {
                case 1:
                    System.out.println("Dime un correo: ");
                    String correo = scanner.nextLine();
                    if (!cliente.buscarCliente(correo)) {
                        System.out.println("Cliente no encontrado. Añadiendo cliente...");
                        System.out.println("Dame un nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Dame un Telefono: ");
                        int telefono = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        cliente.insertarClientes(nombre, correo, telefono);
                    } else {
                        System.out.println("El cliente ya existe.");
                    }
                    break;

                case 2:
                    cliente.mostrarClientes();
                    break;

                case 3:
                    System.out.println("Dime un correo: ");
                    String correos = scanner.nextLine();
                    if (cliente.buscarCliente(correos)) {
                        System.out.println("Dame un nuevo nombre: ");
                        String nombreNuevo = scanner.nextLine();
                        System.out.println("Dame un nuevo Telefono: ");
                        int telefonoNuevo = scanner.nextInt();
                        scanner.nextLine();  // Limpiar el buffer
                        cliente.editarClientes(nombreNuevo, telefonoNuevo, correos);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Dime un correo: ");
                    String email = scanner.nextLine();
                    if (cliente.buscarCliente(email)) {
                        cliente.eliminarClientes(email);
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 5:
                	eleccion = 5;
                    System.out.println("SALIENDO...");
                    break;

                default:
                    System.out.println("OPCIÓN INVÁLIDA.");
            }

        } while (eleccion != 5);  // Repite hasta que elija salir

        scanner.close();
    }
}
