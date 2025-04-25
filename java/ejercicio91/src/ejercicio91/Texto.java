package ejercicio91;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;

public class Texto {

    FileWriter archivo;
    Scanner scanner = new Scanner(System.in);

    public Texto() {
        try {
            archivo = new FileWriter("mensaje.txt", true); 
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void Escribir() {
        String frase;
        System.out.println("¿Qué quieres escribir?");
        frase = scanner.nextLine();
        try {
            archivo.write(frase + "\n"); 
            archivo.flush(); 
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo: " + e.getMessage());
        } finally {
            try {
                if (archivo != null) {
                    archivo.close(); 
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
    public void Leer() {
        try (BufferedReader lector = new BufferedReader(new FileReader("mensaje.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea); 
            }
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo: " + e.getMessage());
        }
    }
}