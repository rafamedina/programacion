package ejercicio34;

public class Empleado {
	
	public String nombre;
	private double salario;
	protected String departamento;
	

	public Empleado(String nombre, double salario, String departamento) {
		this.nombre = nombre;
		this.salario = salario;
		this.departamento = departamento;
	}

	public void mostrarDatos() {
		System.out.println("El empleado " + this.nombre + " cobra " + this.salario + " y pertenece al departamento " + this.departamento);
	}
	
}
