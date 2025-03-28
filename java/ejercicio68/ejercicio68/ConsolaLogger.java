package ejercicio68;

public class ConsolaLogger implements Logger {

	@Override
	public void registrar(String mensaje) {
		
		System.out.println("Bienvenido: " + mensaje);
	}

}
