package ejercicio32;

public class Main {

	public static void main(String[] args) {
		
	persona persona = new persona("Rafa", 24);
	
	persona persona2 = new persona("Rafa");
	
	persona persona3 = new persona();
	
	persona.mostrarDatos();
	persona2.mostrarDatos();
	persona3.mostrarDatos();
	}
}
