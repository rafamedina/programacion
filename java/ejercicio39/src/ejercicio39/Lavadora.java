package ejercicio39;

public class Lavadora extends Electrodomestico {
 public double capacidadKg;
	public Lavadora(String Newmarca, double Newprecio, double capacidadKg) {
		super(Newmarca,Newprecio);
		this.capacidadKg=capacidadKg;
	}
	public void mostrarDatos() {
		System.out.println("La lavadora de la marca "+  this.Marca + " tiene un precio de: " + this.Precio + "€, y tiene una capacidad de: " + this.capacidadKg);
	}
}
