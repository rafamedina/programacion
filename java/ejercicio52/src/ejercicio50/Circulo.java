package ejercicio50;

public class Circulo extends Figura {

	double radio;
	public Circulo(double radio) {
		this.radio=radio;
	}
public void calculararea() {
		System.out.println(3.14*(radio*radio));
	}

}
