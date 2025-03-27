package ejercicio37;

public class Coche extends Vehiculo{
	public int puertas;
	
	
	public Coche(String Newmarca,String NewModelo, int NewPuertas) {	
		super(Newmarca,NewModelo);
		this.puertas = NewPuertas;
	}
	@Override
	public void mostrarDatos() {
		System.out.println("El coche de la marca " + this.marca + " es el modelo: " + this.modelo + " y tiene estas puertas: " + this.puertas);
	}
	
	
}
