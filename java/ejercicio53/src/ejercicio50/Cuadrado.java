package ejercicio50;

public class Cuadrado extends Figura {
	double lado;
	public Cuadrado(double lado) {
		// TODO Auto-generated constructor stub
		this.lado=lado;
	}
public void calculararea() {
		System.out.println(lado*lado);
	}

}
