package paquetes;

public class CalculadoraSimple {
    public void calcular(int numero1,int numero2) {
	int num1 = numero1;
	int num2 = numero2;
 	int resultado;
	resultado = num1 + num2;
        System.out.println("La suma es de:" + resultado);
	resultado = num1 - num2;
        System.out.println("La resta es de:" + resultado);
	resultado = num1 * num2;
        System.out.println("La multiplicacion es de:" + resultado);
	resultado = num1 / num2;
        System.out.println("La division es de:" + resultado);
    }
}
