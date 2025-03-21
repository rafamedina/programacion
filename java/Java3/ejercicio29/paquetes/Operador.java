package paquetes;

public class Operador {

    public void calcular() {
        for (int i = 0; i <= 10; i++) {
            if (i == 8) {
                break; 
            } else if (i != 5) {
                System.out.println(i); // Imprime cuando i no sea 5
            }
        }
    }
}
