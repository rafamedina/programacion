package Controlador;
import Vista.*;
import Modelo.Clientes;
public class ControllerCliente {
    private Vista vista;
    private vistaCliente vcliente;
    private Clientes cliente;
    public ControllerCliente() {
        vista = new Vista();        // Inicializar vista
        cliente= new Clientes();    // Inicializar cliente
        vcliente= new vistaCliente();
    }
	public void menuClientes() {
        int eleccion; 
        do {
            eleccion = vista.menuOperaciones();
            switch (eleccion) {
                case 1:
                	agregarCliente();
                    break;
                case 2:
                    cliente.mostrarClientes();
                    break;
                case 3:
                    datosClientes();
                    break;
                case 4:
                	eliminarClientes();
                    break;
                case 5:
                	eleccion = 5;
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (eleccion != 5);
    }	
	public void agregarCliente() {
         try {
        	 String[] datosCliente = vcliente.obtenerDatosCliente();
        	 cliente.insertarCliente(datosCliente[0], datosCliente[1], datosCliente[2]); 
             vista.mostrarMensaje("Cliente añadido correctamente.");
         } catch(Exception e) {
             vista.mostrarMensaje("Error" + e.getMessage());
         }
	}
	
	
	public void datosClientes() {
		try {
			
			String correocomprobar=vcliente.obtenerCorreo();
			
			if(cliente.buscarCliente(correocomprobar)) {
		String[] nuevosDatos = vcliente.obtenerDatosCliente();
       cliente.editarCliente(nuevosDatos[0], nuevosDatos[1], nuevosDatos[2], correocomprobar);
            vista.mostrarMensaje("Cliente actualizado.");
			}
        } catch(Exception e) {
            vista.mostrarMensaje("Error" + e.getMessage());
        }
	}

	
	
	public void eliminarClientes() {
		try {
		 String emailEliminar = vcliente.obtenerCorreo();
		 cliente.eliminarCliente(emailEliminar);
             vista.mostrarMensaje("Cliente eliminado.");
         } catch(Exception e) {
             vista.mostrarMensaje("Error" + e.getMessage());
         }
 	}
}
