package Controlador;
import Vista.*;
import Modelo.FacturaCliente;
public class ControllerMenu {

	 private Vista vista;
	 private ControllerCliente clienteC;
	 private ControllerProveedor proovedorC;
	 private ControllerArticulo articulosC;
	 private ControllerFacturas facturasC;
	 private ControllerVentas ventasC;
	 private FacturaCliente Fc;
	 public ControllerMenu() {
	        vista = new Vista();                    // Inicializar vista
	        clienteC = new ControllerCliente();    // Inicializar cliente
	        proovedorC = new ControllerProveedor(); // Inicializar proveedor
	        articulosC = new ControllerArticulo();
	        facturasC = new ControllerFacturas();
	        ventasC = new ControllerVentas();
	        Fc = new FacturaCliente();
	 }
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
                   articulosC.menuArticulos();
                    break;
                case 4:
                	ventasC.menuVentas();
                    break;
                case 5:
                    facturasC.menuFacturasRecibidas();
                    break;
                case 6:
                	Fc.mostrar();
                    break;
                case 7:
                	eleccion = 7;
                    vista.mostrarMensaje("SALIENDO...");
                    break;
                default:
                    vista.mostrarMensaje("OPCIÓN INVÁLIDA.");
            }
        } while (eleccion != 7); // Repite hasta que elija salir
    }
}


