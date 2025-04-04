package Utilidades;
import java.util.Scanner;
public class Revista extends Material {

	int numEdicion;
    boolean mensual;
    
	public Revista(String codigo, String titulo, int año,int numEdicion,boolean mensual) {
		super(codigo, titulo, año);
		this.numEdicion=numEdicion;
		this.mensual=mensual;
	}

	@Override
	void mostrar() {
		System.out.println("Revista - Código: " + this.codigo + ", Título: " + this.titulo + ", Año: " + this.año + ", Nº edición: " + this.numEdicion + ", Mensual: " + (this.mensual ? "sí" : "no"));

	}
	public static void añadirRevista(String codigo, Scanner scanner) {
        System.out.print("Introduce el título de la revista: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el año de publicación: ");
        int año = scanner.nextInt();
        System.out.print("Introduce el número de edición: ");
        int numEdicion = scanner.nextInt();
        System.out.print("¿Es mensual? (true/false): ");
        boolean mensual = scanner.nextBoolean();
        scanner.nextLine();  
        Biblioteca.materiales.add(new Revista(codigo, titulo, año, numEdicion, mensual));
    }
}
