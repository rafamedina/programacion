import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        boolean salir = false;
		        Scanner scanner = new Scanner(System.in);  

		        while (salir==false) {  

		            System.out.println("--- MENÚ GESTOR ANIMALES ---");
		            System.out.println("1. Añadir Animal");
		            System.out.println("2. Buscar Animal");
		            System.out.println("3. Salir");
		            System.out.print("Selecciona una opción: ");
		            
		            int opcion = scanner.nextInt(); 
		            
		         
		            switch(opcion) {
		                case 1:
		                    Gestor.añadirAnimales();  
		                    break;  // 
		                case 2:
		                    Gestor.buscarAnimales();
		                    break;
		                case 3:
		                	salir = true; 
		                    break;
		                default:
		                    System.out.println("Opción no válida");
		            }
		        }
		        scanner.close();
	}

}
