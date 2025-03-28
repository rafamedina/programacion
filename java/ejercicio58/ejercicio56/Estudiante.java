package ejercicio56;

public class Estudiante extends Persona {
	String Curso;
	public Estudiante(String nombre,String Curso) {
		super(nombre);
		this.Curso= Curso;
	}
	public void mostrarDatos() {
		System.out.println("El nombre es: " + this.nombre +" y da " + this.Curso);
	}
	
}
