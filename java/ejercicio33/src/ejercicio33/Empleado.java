package ejercicio33;

public class Empleado {

	public String nombre;
	private double saldo;
	
	public Empleado(String NewNombre) {
		this.nombre = NewNombre;
		
	}
	public void setSaldo(double newSaldo) {
		this.saldo=newSaldo;
		
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void depositar(double cantidad) {
		this.saldo += cantidad;
		System.out.println("tu nuevo saldo es de: " + this.saldo);
	}
	
	public void retirar(double cantidad) {
		
		if (this.saldo > cantidad) {
		this.saldo -= cantidad;
		System.out.println("tu nuevo saldo es de: " + this.saldo);
	}
	}
}
