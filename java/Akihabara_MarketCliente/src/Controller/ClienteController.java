package Controller;
import java.util.List;
import DAO.*;
import Model.LlmService;
import Model.ProductoOtaku;
import View.*;
public class ClienteController {
	ProductoDAO productodao = new ProductoDAO();
	InterfazConsolaProducto interfaz = new InterfazConsolaProducto();
	LlmService ia = new LlmService();

	public void gestionMenu() {
	    // Este método es el corazón del sistema. Muestro el menú principal y gestiono la elección del usuario.
	    // Según la opción que elija, llamo al método correspondiente para realizar la acción (insertar, buscar, actualizar, etc.).
	    int eleccion;

	    do {
	        eleccion = interfaz.Menu();

	        switch (eleccion) {
	            case 1:
	                // Inserto un nuevo producto en el sistema.
	                gestionInsertarProducto();
	                break;
	            case 2:
	                // Busco un producto por su ID.
	                gestionBuscarProducto();
	                break;
	            case 3:
	                // Muestro todos los productos disponibles.
	                gestionBuscarProductos();
	                break;
	            case 4:
	                // Actualizo un producto existente.
	                gestionActualizarProducto();
	                break;
	            case 5:
	                // Elimino un producto usando su ID.
	                gestionEliminarProducto();
	                break;
	            case 6:
	                // Busco productos por nombre.
	                gestionBuscarPorNombre();
	                break;
	            case 7:
	                // Entro al submenú de funciones con inteligencia artificial.
	                int eleccion2;
	                do {
	                    eleccion2 = interfaz.menuIA();

	                    switch (eleccion2) {
	                        case 1:
	                            // Pido a la IA que genere una descripción del producto.
	                            descripcionIA();
	                            break;
	                        case 2:
	                        	// Le pido a la IA que sugiera una categoría para un producto.
	                        	categoriaIA();
	                            break;
	                        case 3:
	                            System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
	                            break;
	                        default:
	                            System.out.println("OPCION IA NO VALIDA");
	                            break;
	                    }
	                } while (eleccion2 != 3);
	                break;
	            case 8:
	                System.out.println("SALIENDO DEL MENU...");
	                break;
	            default:
	                System.out.println("OPCION NO VALIDA");
	                break;
	        }

	    } while (eleccion != 8); // Repito el menú hasta que el usuario decida salir
	}

	public void gestionInsertarProducto() {
		// Aquí recojo los datos del nuevo producto desde la interfaz y lo intento agregar a la base de datos.
		ProductoOtaku producto = interfaz.pedirDatos();
		try {
			productodao.AgregarProducto(producto);
		} catch (Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionBuscarProducto() {
		// Solicito un ID y muestro el producto si existe.
		int id = interfaz.pedirId();
		try { 
			ProductoOtaku producto = productodao.obtenerProductoPorId(id);
			interfaz.mostrarProducto(producto);
		} catch( Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionBuscarProductos() {
		// Obtengo y muestro todos los productos de la base de datos.
		try {
			List<ProductoOtaku> datos = productodao.obtenerTodosLosProductos();
			if(datos!= null) {
				interfaz.mostrarProductos(datos);
			}
		} catch (Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}

	public void gestionActualizarProducto() {
	    // Pido el ID del producto a actualizar, lo obtengo y luego pido qué campo quiere cambiar el usuario.
	    int id = interfaz.pedirId();
	    ProductoOtaku producto = productodao.obtenerProductoPorId(id);

	    if (producto == null) {
	    	interfaz.mostrarMensaje("NO SE ENCONTRO NINGUN PRODUCTO CON ESE ID");
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
	                producto = new ProductoOtaku(id, nuevoNombre, producto.getCategoria(), producto.getPrecio(), producto.getStock());
	                break;

	            case "categoria":
	                String nuevaCategoria = interfaz.pedirCategoria();
	                producto = new ProductoOtaku(id, producto.getNombre(), nuevaCategoria, producto.getPrecio(), producto.getStock());
	                break;

	            case "precio":
	                double nuevoPrecio = interfaz.pedirPrecio();
	                producto = new ProductoOtaku(id, producto.getNombre(), producto.getCategoria(), nuevoPrecio, producto.getStock());
	                break;

	            case "stock":
	                int nuevoStock = interfaz.pedirStock();
	                producto = new ProductoOtaku(id, producto.getNombre(), producto.getCategoria(), producto.getPrecio(), nuevoStock);
	                break;
	                
	            case "todo":
	            	ProductoOtaku productox = interfaz.pedirDatos();
	            	producto = new ProductoOtaku(id, productox.getNombre(), productox.getCategoria(), productox.getPrecio(), productox.getStock());
	            	break;

	            default:
	            	interfaz.mostrarMensaje("OPCION NO VALIDA");
	                return;
	        }

	        // Intento actualizar el producto con los nuevos datos.
	        boolean actualizado = productodao.actualizarProducto(producto);
	        if (actualizado) {
	        	interfaz.mostrarMensaje("PRODUCTO ACTUALIZADO CORRECTAMENTE");
	        } else {
	        	interfaz.mostrarMensaje("NO SE PUDO ACTUALIZAR EL PRODUCTO");
	        }

	    } catch (Exception e) {
	    	interfaz.mostrarMensaje("ERROR DURANTE LA ACTUALIZACION: " + e.getMessage());
	    }
	}

	public void gestionEliminarProducto() {
		// Elimino un producto si existe en la base de datos.
		int id = interfaz.pedirId();
		ProductoOtaku producto = productodao.obtenerProductoPorId(id);
		if(producto!=null) {
			try {
				productodao.eliminarProducto(id);
			} catch(Exception e) {
				interfaz.mostrarMensaje("ERROR DURANTE LA ELIMINACION: " + e.getMessage());
			}
		}
	}

	public void gestionBuscarPorNombre() {
		// Busco productos que coincidan con un nombre introducido por el usuario.
		String nombre = interfaz.pedirNombre();
		if(nombre!=null) {
			try {
				List<ProductoOtaku> datos = productodao.buscarProductosPorNombre(nombre);
				if (datos!=null) {
					interfaz.mostrarProductos(datos);
				} else {
					interfaz.mostrarMensaje("NO ES UN NOMBRE VALIDO");
				}
			} catch (Exception e) {
				interfaz.mostrarMensaje("ERROR DURANTE LA BUSQUEDA: " + e.getMessage());
			}
		} else {
			interfaz.mostrarMensaje("NO ES UN NOMBRE VALIDO: ");
		}
	}

	public void descripcionIA() {
		// Le pido a la IA que genere una descripción de marketing para un producto específico.
		try{
			int id = interfaz.pedirId();
			ProductoOtaku productoia = productodao.obtenerProductoPorId(id);
			String prompt = "Genera una descripción de marketing breve y atractiva para el producto otaku: " + productoia.getNombre() + "de la categoría " + productoia.getCategoria() + "no me metas ningun hagstag solo haz la descripcion";
			String respuesta = ia.realizarSolicitud(prompt);
			interfaz.mostrarMensaje("IA: " + respuesta);
		} catch(Exception e) {
			interfaz.mostrarMensaje("ERROR" + e.getMessage());
		}
	}

	public void categoriaIA() {
		// Le pido a la IA que sugiera una categoría para un producto, a partir de su nombre.
		try {
			String NombreNuevo = interfaz.pedirNombre();
			String prompt = "Para un producto otaku llamado : " + NombreNuevo + " , sugiere una categoría adecuada de esta lista: Figura, Manga, Póster, Llavero, Ropa. Videojuego u Otro) Solo dime la categoria nada mas, en una sola palabra y si la respuesta es otro dime que categoria podriamos poner";
			String respuesta = ia.realizarSolicitud(prompt);
			interfaz.mostrarMensaje("IA: " + respuesta);	
		} catch(Exception e) {
			interfaz.mostrarMensaje("ERROR" + e.getMessage());
		}
	}
}

	

