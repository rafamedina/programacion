package Controller;

public class Main {
	
	
	public static void main(String[] args) {
		
		// Este es el método principal. Cuando arranca la aplicación, lo primero que hago es crear una instancia de ProductoController.
		// Luego, llamo a su método gestionMenu(), que se encarga de mostrar y gestionar el menú principal del sistema.
		
		ControllerGeneral cg =new ControllerGeneral();
		cg.Menu();
	}
	
	


}