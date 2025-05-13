package Controlador;
import Modelo.*;
import Vista.*;

public class ProveedorControlador {
    private Vista vista;
    private Proveedores proveedor;
	public void menuProveedores() {
   	 int eleccion;
        do {
            eleccion = vista.menuOperaciones();
            switch (eleccion) {
                case 1:
                   agregarProveedor();
                    break;
                case 2:
               	 proveedor.mostrarProveedores();
                    break;
                case 3:
                	editarProveedor();
                    break;
                case 4:
                	eliminarProveedor();
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
	
public void agregarProveedor() {
	 String[] datosProveedor = vista.obtenerDatosProveedor();
     if (proveedor.insertarProveedor(datosProveedor[0], datosProveedor[1], datosProveedor[2])) {
         vista.mostrarMensaje("Proveedor añadido correctamente.");
     } else {
         vista.mostrarMensaje("Error al añadir Proveedor.");
     }
}

public void editarProveedor() {
	String[] nuevosDatos = vista.obtenerDatosProveedor();
    if (proveedor.editarProveedor(nuevosDatos[0], nuevosDatos[1], nuevosDatos[2])) {
        vista.mostrarMensaje("Proveedor actualizado.");
    } else {
        vista.mostrarMensaje("Error al editar Proveedor.");
    }
}
public void eliminarProveedor() {
	String cifEliminar = vista.obtenerCif();
    if (proveedor.eliminarProveedor(cifEliminar)) {
        vista.mostrarMensaje("Proveedor eliminado.");
    } else {
        vista.mostrarMensaje("Error al eliminar Proveedor.");
    }
}
}
