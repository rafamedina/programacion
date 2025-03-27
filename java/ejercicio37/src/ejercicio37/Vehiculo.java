package ejercicio37;

public class Vehiculo {

	public String marca;
	public String modelo;
	
	
	public Vehiculo(String NewMarca,String NewModelo) {	
		this.marca = NewMarca;
		this.modelo = NewModelo;		
	}

	public void mostrarDatos() {
		System.out.println("El coche de la marca " + this.marca + " es el modelo: " + this.modelo);
	}
}
