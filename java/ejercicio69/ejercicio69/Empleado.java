package ejercicio69;

public class Empleado implements Identificable {
String nombre;
int id;

	public Empleado(String nombre,int id) {
		this.nombre=nombre;
		this.id=id;
	}
	@Override
	public void mostrarIdentidad() {
			System.out.println("Hola soy " + this.nombre + " y mi id es: " + this.id);

	}

}
