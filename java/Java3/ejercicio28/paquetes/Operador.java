package paquetes;
import java.util.Scanner;

public class Operador {
    private int suma;

    // Constructor corregido, mismo nombre que la clase y sin void
    public Operador() {
        this.suma = 0;
    }

    public void iniciarSuma() {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Ingresa un número (0 para terminar): ");
            numero = scanner.nextInt();
            suma += numero;
        } while (numero != 0);

        System.out.println("La suma de los números ingresados es: " + suma);
        scanner.close();
    }

    public int getSuma() {
        return suma;
    }
}
