package Controlador;
import Vista.*;
import Modelo.Clientes;
public class ControllerCliente {
    private Vista vista;
    private vistaCliente vcliente;
    private Clientes cliente;
    public ControllerCliente() {
        vista = new Vista();                    // Inicializar vista
        cliente= new Clientes();    // Inicializar cliente
       
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
		 String[] datosCliente = vcliente.obtenerDatosCliente();
         if (cliente.insertarCliente(datosCliente[0], datosCliente[1], datosCliente[2])) {
             vista.mostrarMensaje("Cliente añadido correctamente.");
         } else {
             vista.mostrarMensaje("Error al añadir cliente.");
         }
	}
	public void datosClientes() {
		String[] nuevosDatos = vcliente.obtenerDatosCliente();
        if (cliente.editarCliente(nuevosDatos[0], nuevosDatos[1], nuevosDatos[2])) {
            vista.mostrarMensaje("Cliente actualizado.");
        } else {
            vista.mostrarMensaje("Error al editar cliente.");
        }
	}	
	public void eliminarClientes() {
		 String emailEliminar = vcliente.obtenerCorreo();
         if (cliente.eliminarCliente(emailEliminar)) {
             vista.mostrarMensaje("Cliente eliminado.");
         } else {
             vista.mostrarMensaje("Error al eliminar cliente.");
         }
	}
}
