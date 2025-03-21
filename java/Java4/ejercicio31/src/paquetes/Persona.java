package paquetes;

public class Persona {
	public String nombre;
	public int edad;	
	public Persona(String Newnombre, int newedad) {
		
		this.nombre = Newnombre ;
		this.edad = newedad;
		
	}
	
	public void mostrarDatos() {
		System.out.println(this.nombre);
		System.out.println(this.edad);
	}
}
