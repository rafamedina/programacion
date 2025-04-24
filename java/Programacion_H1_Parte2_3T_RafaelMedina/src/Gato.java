import java.util.Scanner;


public class Gato extends Animal {
    boolean testleucemia;

    public Gato(int numerochip, String nombre, int edad, String raza, boolean adoptado, boolean testleucemia) {
        super(numerochip, nombre, edad, raza, adoptado);
        this.testleucemia = testleucemia;
    }

    @Override
    public void mostrar() {
        System.out.println("Gato:");
        System.out.println("Chip: " + numerochip);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
        System.out.println("Adoptado: " + (adoptado ? "Sí" : "No"));
        System.out.println("Test de leucemia: " + (testleucemia ? "Sí" : "No"));
    }

    public static Gato añadirGato(int numerochip, Scanner scanner) {
        System.out.println("Introduce el nombre del gato: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce la raza: ");
        String raza = scanner.nextLine();
        System.out.print("¿Está adoptado? true(si)/false(no): ");
        boolean adoptado = scanner.nextBoolean();
        System.out.print("¿Tiene el test de leucemia hecho? true(si)/false(no): ");
        boolean testleucemia = scanner.nextBoolean();
        scanner.nextLine();
        return new Gato(numerochip, nombre, edad, raza, adoptado, testleucemia);
    }
}

