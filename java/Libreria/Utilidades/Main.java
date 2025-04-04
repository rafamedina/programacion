package Utilidades;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);  // Crear un solo objeto Scanner para todo el programa

        while (salir==false) {  

            System.out.println("--- MENÚ BIBLIOTECA ESCOLAR ---");
            System.out.println("1. Añadir material");
            System.out.println("2. Mostrar todos los materiales");
            System.out.println("3. Buscar material por código");
            System.out.println("4. Eliminar material");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            int opcion = scanner.nextInt(); 
            
         
            switch(opcion) {
                case 1:
                    Biblioteca.añadirMaterial();  
                    break;  // 
                case 2:
                    Biblioteca.mostrarMateriales(); 
                    break;
                case 3:
                    Biblioteca.buscarMaterial(); 
                    break;
                case 4:
                    Biblioteca.eliminarMaterial(); 
                    break;
                case 5:
                    salir = true; 
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}
