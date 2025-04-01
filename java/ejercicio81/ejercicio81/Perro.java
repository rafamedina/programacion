package ejercicio81;

public class Perro extends Animal implements Comunicable {

	public Perro(String nombre) {
		super(nombre);
		
	}

	@Override
	public void hacerSonido() {
		System.out.println("Guau");

	}

}
