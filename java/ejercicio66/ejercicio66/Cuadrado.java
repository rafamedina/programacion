package ejercicio66;

public class Cuadrado implements Figura {
	int lado;
	
	public Cuadrado(int lado) {
		this.lado=lado;
	}
	@Override
	public void calcularArea() {
		System.out.println(lado*lado);
	}

}
