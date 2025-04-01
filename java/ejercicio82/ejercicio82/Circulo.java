package ejercicio82;

public class Circulo extends Figura implements Calculable {
	
	double radio;
	public Circulo(double radio) {
		this.radio=radio;
	}
	
	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		
		
		return this.radio * 4.14;
	}

}
