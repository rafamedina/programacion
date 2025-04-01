package ejercicio80;

public class Bicicleta extends Vehiculo implements Movible {

	public Bicicleta(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		System.out.println("Bicicleta " + this.id + " pedalea por el carril bici");
	}

}
