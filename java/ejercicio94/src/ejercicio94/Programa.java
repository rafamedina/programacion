package ejercicio94;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class Programa {

	FileWriter archivo1;
	FileWriter archivo2;
	Scanner scanner = new Scanner(System.in);
	
	public void crearArchivos() {
        try {
            archivo1 = new FileWriter("archivo1.txt");
            archivo2 = new FileWriter("archivo2.txt");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
	
	public void abrirArchivo() {
		String buscado;
		System.out.println("Que archivo quieres buscar: ");
		buscado = scanner.nextLine();
		
		try{BufferedReader lector = new BufferedReader(new FileReader(buscado+".txt"));
		
		System.out.println("Archivo encontrado, " + buscado + " existe.");
				
		
	} catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
	}}
}
