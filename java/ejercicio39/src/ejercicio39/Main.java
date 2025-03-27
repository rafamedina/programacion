package ejercicio39;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lavadora lavadora = new Lavadora("LG", 1500, 300);
		lavadora.mostrarDatos();
		Televisor televisor = new Televisor("Samsung", 2000, 70);
		televisor.mostrarDatos();
		
		Circulo circulo = new Circulo(15);
		circulo.calcularArea();
		Rectangulo rectangulo = new Rectangulo(2,2);
		rectangulo.calcularArea();
		
	}
	

}
