import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1 - VER PELICULAS");
            System.out.println("2 - SALIR");
            System.out.print("OPCION: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Peliculas.verPeliculas();
                    break;
                case 2:
                    System.out.println("HASTA LUEGO");
                    break;
                default:
                    System.out.println("OPCION NO VALIDA");
            }

        } while (opcion != 2);

        scanner.close();
    }
}

