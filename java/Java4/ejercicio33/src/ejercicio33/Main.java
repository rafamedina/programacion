package ejercicio33;

public class Main {

	public static void main(String[] args) {
		
		Empleado empleado = new Empleado("Rafa");
		
		empleado.setSaldo(2000);
		
		empleado.depositar(1500);
		
		empleado.retirar(1000);
		
		empleado.getSaldo();
		
		
	}

}
