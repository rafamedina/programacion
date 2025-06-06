package Controller;
import java.sql.Date;
import java.util.List;
import DAO.*;
import Model.ClienteOtaku;
import Model.LlmService;
import Model.ProductoOtaku;
import View.*;
public class ClienteController {
	ClienteDAO clientedao = new ClienteDAO();
	InterfazConsolaCliente interfaz = new InterfazConsolaCliente();

	public void gestionMenu() {
	    // Este método es el corazón del sistema. Muestro el menú principal y gestiono la elección del usuario.
	    // Según la opción que elija, llamo al método correspondiente para realizar la acción (insertar, buscar, actualizar, etc.).
	    int eleccion;

	    do {
	        eleccion = interfaz.MenuCliente();

	        switch (eleccion) {
	            case 1:
	                // Inserto un nuevo producto en el sistema.
	            	gestionInsertarCliente();
	                break;
	            case 2:
	                // Busco un producto por su ID.
	            	gestionBuscarCliente();
	                break;
	            case 3:
	                // Muestro todos los productos disponibles.
	            	gestionBuscarClientes();
	                break;
	            case 4:
	                // Actualizo un producto existente.
	            	gestionActualizarCliente();
	                break;
	            case 5:
	                // Elimino un producto usando su ID.
	            	gestionEliminarCliente();
	                break;
	            case 6:
	                // Busco productos por nombre.
	                gestionBuscarPorNombre();
	                break;
	            case 7:
	                System.out.println("SALIENDO DEL MENU...");
	                break;
	            default:
	                System.out.println("OPCION NO VALIDA");
	                break;
	        }

	    } while (eleccion != 7); // Repito el menú hasta que el usuario decida salir
	}

	public void gestionInsertarCliente() {
		// Aquí recojo los datos del nuevo producto desde la interfaz y lo intento agregar a la base de datos.
		ClienteOtaku cliente = interfaz.pedirDatos();
		try {
			clientedao.agregarCliente(cliente);
		} catch (Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionBuscarCliente() {
		// Solicito un ID y muestro el producto si existe.
		int id = interfaz.pedirId();
		try { 
			ClienteOtaku cliente = clientedao.obtenerClientePorId(id);
			interfaz.mostrarCliente(cliente);
		} catch( Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionBuscarClientes() {
		// Obtengo y muestro todos los productos de la base de datos.
		try {
			List<ClienteOtaku> datos = clientedao.obtenerTodosLosClientes();
			if(datos!= null) {
				interfaz.mostrarClientes(datos);
			}
		} catch (Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionActualizarCliente() {
	    // Pido el ID del producto a actualizar, lo obtengo y luego pido qué campo quiere cambiar el usuario.
	    int id = interfaz.pedirId();
	    ClienteOtaku cliente = clientedao.obtenerClientePorId(id);

	    if (cliente == null) {
	    	interfaz.mostrarMensaje("NO SE ENCONTRO NINGUN CLIENTE CON ESE ID");
	        return;
	    }

	    String seleccion = interfaz.pedirEdicion();

	    if (seleccion == null) {
	        return; 
	    }

	    try {
	        // Según lo que quiera cambiar el usuario, creo un nuevo objeto con los valores actualizados.
	        switch (seleccion) {
	            case "nombre":
	                String nuevoNombre = interfaz.pedirNombre();
	                cliente = new ClienteOtaku(id, nuevoNombre, cliente.getEmail(), cliente.getTelefono(), cliente.getFecha_registro());
	                break;

	            case "email":
	                String nuevoEmail = interfaz.pedirEmail();
	                cliente = new ClienteOtaku(id, cliente.getNombre(), nuevoEmail, cliente.getTelefono(), cliente.getFecha_registro());
	                break;

	            case "telefono":
	                String nuevoTelefono = interfaz.pedirTelefono();
	                cliente = new ClienteOtaku(id, cliente.getNombre(), cliente.getEmail(), nuevoTelefono, cliente.getFecha_registro());
	                break;
	                
	            case "todo":
	            	ClienteOtaku clientex = interfaz.pedirDatos();
	            	cliente = new ClienteOtaku(id, clientex.getNombre(), clientex.getEmail(), clientex.getTelefono(), clientex.getFecha_registro());
	            	break;

	            default:
	            	interfaz.mostrarMensaje("OPCION NO VALIDA");
	                return;
	        }

	        // Intento actualizar el cliente con los nuevos datos.
	        boolean actualizado = clientedao.actualizarCliente(cliente);
	        if (actualizado) {
	        	interfaz.mostrarMensaje("CLIENTE ACTUALIZADO CORRECTAMENTE");
	        } else {
	        	interfaz.mostrarMensaje("NO SE PUDO ACTUALIZAR EL CLIENTE");
	        }

	    } catch (Exception e) {
	    	interfaz.mostrarMensaje("ERROR DURANTE LA ACTUALIZACION: " + e.getMessage());
	    }
	}

	public void gestionEliminarCliente() {
		// Elimino un producto si existe en la base de datos.
		int id = interfaz.pedirId();
		ClienteOtaku cliente = clientedao.obtenerClientePorId(id);
		if(cliente!=null) {
			try {
				clientedao.eliminarCliente(id);
			} catch(Exception e) {
				interfaz.mostrarMensaje("ERROR DURANTE LA ELIMINACION: " + e.getMessage());
			}
		}
	}

	public void gestionBuscarPorNombre() {
		// Busco productos que coincidan con un nombre introducido por el usuario.
		String email = interfaz.pedirEmail();
		if(email!=null) {
			try {
				ClienteOtaku datos = clientedao.buscarPorEmail(email);
				if (datos!=null) {
					interfaz.mostrarCliente(datos);
				} else {
					interfaz.mostrarMensaje("NO ES UN EMAIL VALIDO");
				}
			} catch (Exception e) {
				interfaz.mostrarMensaje("ERROR DURANTE LA BUSQUEDA: " + e.getMessage());
			}
		} else {
			interfaz.mostrarMensaje("NO ES UN EMAIL VALIDO: ");
		}
	}
}

	

