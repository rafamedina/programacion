package Utilidades;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	static ArrayList<Material> materiales = new ArrayList<>();
	 static Scanner scanner = new Scanner(System.in);
	 static {
	        materiales.add(new Libro("L001", "Programación en Java", 2021, "Ana García", 350));
	        materiales.add(new Revista("R010", "Ciencia Escolar", 2023, 12, true));
	        materiales.add(new Libro("L002", "Matemáticas Básicas", 2019, "Carlos Ruiz", 200));
	        materiales.add(new Revista("R011", "Arte y Diseño", 2022, 7, false));
	    	}

	 
	 public static void añadirMaterial() {
	        System.out.print("Introduce el código del material: ");
	        String codigo = scanner.nextLine();

	        
	        for (Material m : materiales) {
	            if (m.getCodigo().equals(codigo)) {
	                System.out.println("Ya existe un material con ese código. No se ha añadido.");
	                return;
	            }
	        }

	       
	        System.out.print("¿Es un libro o una revista? (libro/revista): ");
	        String tipo = scanner.nextLine();
	        tipo = tipo.toLowerCase();
	        if (tipo.equals("libro")) {
	            Libro.añadirLibro(codigo, scanner);
	        } else if (tipo.equals("revista")) {
	            Revista.añadirRevista(codigo, scanner);
	        } else {
	            System.out.println("Tipo no válido.");
	            return;
	        }

	        System.out.println("¡Material añadido correctamente!");
	    }
	 
	
	 
	 public static void mostrarMateriales() {
		 for( Material m : materiales) {
			 m.mostrar();
		 }
	 }
	 
	 
	 public static void buscarMaterial() {
		 System.out.print("Introduce el código del material: ");
	        String codigo = scanner.nextLine();

	        
	        for (Material m : materiales) {
	            if (m.getCodigo().equals(codigo)) {
	                m.mostrar();
	                return;
	            } else {
	            	System.out.println("No se ha encontrado el material");
	            }
	        }
	 
	  
	    
	 
	 }
	 
	 public static void eliminarMaterial() {
		 System.out.println("Introduce el código del material: ");
		 String codigo = scanner.nextLine();
		 
		 for (Material m : materiales) {
	            if (m.getCodigo().equals(codigo)) {
	                materiales.remove(m);
	                return;
	            } 
	        }
	 
	 }
	 
	 
	
}	

