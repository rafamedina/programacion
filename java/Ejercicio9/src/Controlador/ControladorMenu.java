package Controlador;
import Vista.*;

public class ControladorMenu {

	 private Vista vista;
	 private ClienteControlador clienteC;
	 private ProveedorControlador proovedorC;
    public void menuPrincipal() {
        int eleccion;
        do {
            eleccion = vista.menuPrincipal();  // Obtener opción del menú
            switch (eleccion) {
                case 1:
                	clienteC.menuClientes();
                    break;
                case 2:
                	proovedorC.menuProveedores();
                    break;
                case 3:
//                    menuArticulos();
                    break;
                case 4:
//                    menuVentas();
                    break;
                case 5:
//                    menuFacturasRecibidas();
                    break;
                case 6:
                	eleccion = 6;
                    vista.mostrarMensaje("SALIENDO...");
                    break;
                default:
                    vista.mostrarMensaje("OPCIÓN INVÁLIDA.");
            }
        } while (eleccion != 6); // Repite hasta que elija salir
    }
}


