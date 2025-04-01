package ejercicio80;

public class Coche extends Vehiculo implements Movible {

	public Coche(String id) {
		super(id);
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		System.out.println("Coche " + this.id + " se mueve por carretera");
	}

}
