package ejercicio70;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int[] numeros = new int[5];

	        for (int i = 0; i < 5; i++) {
	            System.out.print("Introduce un número para la posición " + i + ": ");
	            numeros[i] = scanner.nextInt();
	        }
	        System.out.println("Los valores introducidos son:");
	        for (int num : numeros) {
	            System.out.print(num + " ");
	        }
	    }
	}
