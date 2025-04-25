package ejercicio90;
import java.util.Scanner;
public class numeros {
	int numero1;
	int numero2;
	 static Scanner scanner = new Scanner(System.in);
	public void operacion(){
		try {
			System.out.println("dame el numero 1: ");
			this.numero1=scanner.nextInt();
			System.out.println("dame el numero 2: ");
			this.numero2=scanner.nextInt();
			System.out.println("El resultado es: " + this.numero1/this.numero2);
		} catch(Exception e) {
			System.out.println("Algo ha ocurrido mal");
		}
	}
}
