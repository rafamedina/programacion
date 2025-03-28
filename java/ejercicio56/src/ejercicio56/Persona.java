package ejercicio56;

public class Persona {
	String nombre;
	
	public Persona(String nombre) {
		this.nombre=nombre;
	}

	
	public void mostrarDatos() {
		System.out.println("El nombre es: " + this.nombre);
	}
	
}
