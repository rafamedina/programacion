package ejercicio39;

public class Rectangulo extends Figura {
	double base;
	double altura;
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	@Override
	public void calcularArea() {
		// TODO Auto-generated method stub
	 System.out.println((this.base*this.altura)/2);
	}

}
