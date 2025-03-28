package ejercicio56;

public class Profesor extends Persona {

	String asignatura;
	public Profesor(String nombre,String asignatura) {
		super(nombre);
		this.asignatura=asignatura;
	}
	public void mostrarDatos() {
		System.out.println("El nombre es: " + this.nombre +" y da " + this.asignatura);
	}
	
}
