import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1 - VER PELICULAS");
            System.out.println("2 - AÑADIR PELICULA");
            System.out.println("3 - ELIMINAR PELICULA");
            System.out.println("4 - MODIFICAR PELICULA");
            System.out.println("5 - SALIR");
            System.out.print("OPCION: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Peliculas.verPeliculas();
                    break;
                case 2:
                    Gestor.anadirPelicula();
                    break;
                case 3:
                    Gestor.eliminarPelicula();
                    break;
                case 4:
                    Gestor.modificarPelicula();
                    break;
                case 5: 
                	opcion = 5;
                	System.out.println("Hasta luego");

                default:
                    System.out.println("OPCION NO VALIDA");
                    
              
            }

        } while (opcion != 5);

        scanner.close();
    }
}

