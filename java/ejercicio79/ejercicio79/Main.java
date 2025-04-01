package ejercicio79;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> nombres = new ArrayList<>();
		nombres.add("Rafa");
		nombres.add("iker");
		nombres.add("marcos");
		nombres.add("sergio");
		nombres.add("Iris");
		
		for(String nombre: nombres) {
			System.out.println(nombre.toUpperCase());
		}
	}

}
