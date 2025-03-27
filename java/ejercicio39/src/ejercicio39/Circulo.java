package ejercicio39;

public class Circulo extends Figura {

	public double Area;
	public Circulo(double Area) {
		// TODO Auto-generated constructor stub
		this.Area=Area;
	}
	@Override
	public void calcularArea() {
		System.out.println(3.14*this.Area);
	};
}
