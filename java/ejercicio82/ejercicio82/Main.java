package ejercicio82;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Calculable> figuras = new ArrayList<>();
		
		figuras.add(new Circulo(3.3223));
		figuras.add(new Circulo(7));
		figuras.add(new Rectangulo(3,6));
		figuras.add(new Rectangulo(15,3));
		
		for(Calculable figura : figuras) {
			System.out.println(figura.calcularArea());
		
		}
	}

}
