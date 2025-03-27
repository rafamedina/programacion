package ejercicio42;

public class Estudiante extends Persona {
	
	String curso;
	public Estudiante (String nombre, int edad ,String curso) {
		super(nombre,edad);
		this.curso =curso;
	}
	public void mostrarDatos() {
		System.out.println(getNombre() + ", " + getEdad() + "," + this.curso);
	}

}
