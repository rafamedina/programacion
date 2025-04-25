package ejercicio93;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class Operaciones {

	FileWriter archivo;
	Scanner scanner = new Scanner(System.in);
	
	public void Escribir() {
		int numero;
		try {
			archivo = new FileWriter("numeros.txt",true);
			System.out.println("Añade un numero: ");
			numero = scanner.nextInt() ;
			archivo.write(numero + "\n");
			archivo.flush();
	} catch(IOException e) {
		System.out.println("error al escribir en el archivo: "+ e.getMessage());
	} finally {
		try {
			archivo.close();
			
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}}}
	
	public void mostrarSuma() {
	    int resultado = 0;
	    try (BufferedReader leido = new BufferedReader(new FileReader("numeros.txt"))) {
	        String linea;
	        while ((linea = leido.readLine()) != null) { 
	            try {
	                int numero = Integer.parseInt(linea);
	                resultado += numero;
	            } catch (NumberFormatException e) {
	                System.out.println("Error al convertir la línea a número: " + e.getMessage());
	            } catch (ArithmeticException e) {
	                System.out.println("Error aritmético: " + e.getMessage());
	            }
	        }
	        System.out.println("La suma total es: " + resultado); 
	    } catch (IOException e) {
	        System.out.println("Error al leer el archivo: " + e.getMessage());
	    }
	}
}
