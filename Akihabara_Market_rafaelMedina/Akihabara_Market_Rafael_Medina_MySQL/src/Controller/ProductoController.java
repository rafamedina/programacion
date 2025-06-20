package Controller;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DAO.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import Model.LlmService;
import Model.ProductoOtaku;
import View.*;
public class ProductoController {
    ProductoDAO productodao = new ProductoDAO();
    InterfazProducto interfaz;
    LlmService ia = new LlmService();

    // Constructor que recibe la interfaz real conectada al JFrame
    public ProductoController(InterfazProducto interfaz) {
        this.interfaz = interfaz;
    }


	
	public void gestionInsertarCliente() {
		
		ProductoOtaku producto = interfaz.pedirDatos();
		try {
			productodao.AgregarProducto(producto);
		} catch (Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}
	
	
	public void gestionBuscarProducto() {
		int id = interfaz.pedirId();
		try { 
			ProductoOtaku producto = productodao.obtenerProductoPorId(id);
			interfaz.mostrarProducto(producto);
		} catch( Exception e) {
			interfaz.mostrarMensaje("ERROR " + e.getMessage());
		}
	}
	public void gestionBuscarProductos() {
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
	
	public String generarDescripcionIAyRetornar(int id) {
	    try {
	        ProductoOtaku producto = productodao.obtenerProductoPorId(id);
	        String prompt = "Genera una descripción de marketing breve y atractiva para el producto otaku: " + producto.getNombre() + "de la categoría " + producto.getCategoria() + "no me metas ningun hagstag solo haz la descripcion";
	        return ia.realizarSolicitud(prompt);
	    } catch (Exception e) {
	        return "ERROR: " + e.getMessage();
	    }
	}

	public String generarCategoriaIAyRetornar(String nombreNuevo) {
	    try {
	        String prompt = "Para un producto otaku llamado : " + nombreNuevo + " , sugiere una categoría adecuada de esta lista: Figura, Manga, Póster, Llavero, Ropa. Videojuego u Otro) Solo dime la categoria nada mas, en una sola palabra y si la respuesta es otro dime que categoria podriamos poner";
	        return ia.realizarSolicitud(prompt);
	    } catch (Exception e) {
	        return "ERROR: " + e.getMessage();
	    }
	}



	}
	

