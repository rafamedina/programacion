import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while (!salir) {
            // Menú
            System.out.println("--- MENÚ GESTOR ANIMALES ---");
            System.out.println("1. Dar de alta animal");
            System.out.println("2. Listar animales");
            System.out.println("3. Buscar animal");
            System.out.println("4. Realizar adopción");
            System.out.println("5. Dar de baja");
            System.out.println("6. Mostrar estadísticas de gatos");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir salto de línea

            switch (opcion) {
                case 1:
                    Gestor.añadirAnimales();
                    break;
                case 2:
                    Gestor.listarAnimales();
                    break;
                case 3:
                    Gestor.buscarAnimales();
                    break;
                case 4:
                    Gestor.realizarAdopcion();
                    break;
                case 5:
                    Gestor.darDeBaja();
                    break;
                case 6:
                    Gestor.mostrarEstadisticasGatos();
                    break;
                case 7:
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor elige una opción válida.");
                    break;
            }
        }
        scanner.close();
    }
}

