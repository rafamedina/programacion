package ejercicio81;

public class Gato extends Animal implements Comunicable {

	public Gato(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hacerSonido() {
		// TODO Auto-generated method stub
		System.out.println("Miau");
	}

}
