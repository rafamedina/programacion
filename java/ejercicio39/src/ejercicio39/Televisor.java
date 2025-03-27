package ejercicio39;

public class Televisor extends Electrodomestico{
	public double pulgadas;
	public Televisor(String Newmarca, double Newprecio, double pulgadas) {
		super(Newmarca,Newprecio);
		this.pulgadas=pulgadas;
	}
	public void mostrarDatos() {
		System.out.println("La lavadora de la marca "+  this.Marca + " tiene un precio de: " + this.Precio + "€, y tiene un tamaño de: " + this.pulgadas + " pulgadas");
	}

}
