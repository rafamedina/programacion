package ejercicio32;

public class persona {
	public String nombre;
	public int edad;	
	public persona() {
		
		this.nombre = "desconocido" ;
		this.edad = 0;
		
	}
public persona(String nombre) {
		
		this.nombre = nombre ;
		this.edad = 0;
		
	}

public persona(String Newnombre, int newedad) {
	
	this.nombre = Newnombre ;
	this.edad = newedad;
	
}
	
	public void mostrarDatos() {
		System.out.println(this.nombre);
		System.out.println(this.edad);
	}
}

