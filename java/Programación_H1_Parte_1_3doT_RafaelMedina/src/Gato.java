import java.util.Scanner;


public class Gato extends Animal {
	boolean testleucemia;
	// Constructor del gato. Aquí recibo todos los datos del animal, además del resultado del test de leucemia.
	// Asigno ese valor al atributo correspondiente.
	public Gato(int numerochip, String nombre, int edad, String raza, boolean adoptado, boolean testleucemia) {
		super(numerochip, nombre, edad, raza, adoptado);
		this.testleucemia = testleucemia;
	}

	// Este método me permite mostrar por pantalla toda la información del gato.
	// Incluye si fue adoptado y si tiene hecho el test de leucemia.
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

	// Con este método creo un objeto Gato desde el menú, pidiendo los datos por consola.
	// Si todo es correcto, devuelvo el nuevo gato. Si hay algún error, muestro el mensaje y devuelvo null.
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
	    scanner.nextLine(); 

	    System.out.print("¿Tiene el test de leucemia hecho? true(si)/false(no): ");
	    boolean testleucemia = scanner.nextBoolean();
	    scanner.nextLine(); 
	        return new Gato(numerochip, nombre, edad, raza, adoptado, testleucemia);
	}
}
