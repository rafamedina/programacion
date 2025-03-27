package ejercicio50;

public class Rectangulo extends Figura {
double base;
double altura;
	public Rectangulo(double base, double altura) {
		this.base =base;
		this.altura = altura;
	}
public void calculararea() {
		System.out.println((base*altura)/2);
	}

}
