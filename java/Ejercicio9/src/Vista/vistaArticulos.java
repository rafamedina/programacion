package Vista;
import java.util.Scanner;

import Modelo.Articulos;

import java.util.ArrayList;
public class vistaArticulos {

	    private Scanner scanner;

	    public vistaArticulos() {
	        this.scanner = new Scanner(System.in);
	    }
	    public String[] obtenerDatosArticulos() {
	        System.out.print("Introduce el nombre del articulo: ");
	        String nombre = scanner.nextLine();

	        System.out.print("Introduce el Precio del articulo: ");
	        String precio = scanner.nextLine();


	        System.out.print("Introduce el Stock del articulo: ");
	        String stock = scanner.nextLine();


	        return new String[] { nombre, precio,stock };
	    }

	    public String obtenerNombre() {
	        System.out.print("Introduce el nombre del articulo: ");
	        return scanner.nextLine();
	    }
	}
