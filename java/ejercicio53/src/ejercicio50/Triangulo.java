package ejercicio50;

public class Triangulo extends Figura {
	double base;
	double altura;
	
	public Triangulo(double base, double altura) {
		this.base=base;
		this.altura=altura;
	}
public void calculararea() {
		System.out.println((base*altura)/2);
	}

}
