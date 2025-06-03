package Controller;
import Model.LlmService;

public class Main {
	
	public static void main(String[] args) {
		
		
		ProductoController controller = new ProductoController();
		// controller.gestionMenu();
		GuiController gui = new GuiController();
		gui.setVisible(true);
	}

}
