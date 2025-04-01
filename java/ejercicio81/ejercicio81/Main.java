package ejercicio81;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Comunicable> animal = new ArrayList<>();
		animal.add(new Gato("Persa"));
		animal.add(new Gato("Siames"));
		animal.add(new Perro("Dogo"));
		animal.add(new Perro("Coker"));
	
	
	for(Comunicable animalillo : animal) {
		animalillo.hacerSonido();
	}

}
}