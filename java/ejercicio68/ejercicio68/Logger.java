package ejercicio68;

public interface Logger {
	void registrar(String mensaje);
	static void separador() {
		System.out.println("-----------------------------");
	};
}
