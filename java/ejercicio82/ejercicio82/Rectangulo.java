package ejercicio82;

public class Rectangulo extends Figura implements Calculable {
	
	double lado;
	double altura;

	public Rectangulo(double lado,double altura) {
		this.lado = lado;
		this.altura = altura;
	}
	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return this.lado * this.altura;
	}

}
