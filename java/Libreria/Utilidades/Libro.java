package Utilidades;
import java.util.Scanner;

public class Libro extends Material {
	
	 String autor;
     int paginas;
	
	
	public Libro(String codigo, String titulo, int año, String autor, int paginas ) {
		super(codigo, titulo, año);
		this.autor=autor;
		this.paginas=paginas;
	}
	
	@Override
	void mostrar() {
		
		System.out.println("Libro - Código: " + this.codigo + ", Título: " + this.titulo + ", Año: " + this.año + ", Autor: " + this.autor + ", Páginas: " + this.paginas);
	}

	
	
	public static void añadirLibro(String codigo, Scanner scanner) {
		System.out.println("Introduce el título del libro: ");
		String titulo = scanner.nextLine();
		System.out.println();
		System.out.print("Introduce el año de publicación: ");
	    int año = scanner.nextInt();
	    scanner.nextLine(); 
	    System.out.print("Introduce el autor: ");
	    String autor = scanner.nextLine();
	    System.out.print("Introduce el número de páginas: ");
	    int paginas = scanner.nextInt();
	    Biblioteca.materiales.add(new Libro(codigo, titulo, año, autor, paginas));
	}
	
	
	
	
	
	
	
	
	
	
	
}
