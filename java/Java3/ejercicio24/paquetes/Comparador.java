package paquetes;

public class Comparador {
    public void compararNumeros(int a, int b) {
        if (a > b) {
            System.out.println("El numero " + a + " es mayor");
        } else if (b > a) {
            System.out.println("El numero " + b + " es mayor");
        } else {
            System.out.println("Son iguales");
        }
    }
}

