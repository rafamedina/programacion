package Controller;

import DAO.ProductoDAO;
import View.InterfazConsolaProducto;

public class ControllerGeneral {
	ProductoController Pcontroller = new ProductoController();
	ClienteController Ccontroller = new ClienteController();
	InterfazConsolaProducto interfaz = new InterfazConsolaProducto();
	ProductoDAO productodao = new ProductoDAO();
	public void Menu() {
		SetupDatos.cargarProductosIniciales(productodao);
	    int eleccion;

	    do {
	        eleccion = interfaz.Menu();

	        switch (eleccion) {
	            case 1:
	                Pcontroller.gestionMenu();
	                break;
	            case 2:
	            	Ccontroller.gestionMenu();
	                break;
	            case 3:
	            	System.out.println("Adios, saliendo...");
	                eleccion = 3;
	                
	                break;
	                
	            default:
	                System.out.println("Opcion no válida");
	                break;
	        }

	    } while (eleccion != 3); // Repito el menú hasta que el usuario decida salir
	}
	}

