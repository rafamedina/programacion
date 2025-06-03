package Default;
import java.util.Scanner;
public class UsuarioView {
	
	Scanner scanner = new Scanner(System.in);
	
	public void mostrarMensaje(String Mensaje){
		System.out.println(Mensaje);
	}
	

	public int pedirID() {
		System.out.println("Que id quieres eliminar ");
		int id = scanner.nextInt();
		return id;
	}
	
	
	
}
