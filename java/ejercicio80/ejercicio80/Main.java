package ejercicio80;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Movible> movibles = new ArrayList<>();
		
		 	movibles.add(new Coche("Toyota"));
	        movibles.add(new Bicicleta("B456"));
	        movibles.add(new Coche("Seat"));
	        movibles.add(new Bicicleta("B101"));
		
	        for(Movible movible : movibles) {
	        	movible.mover();
	        }
	}

}
