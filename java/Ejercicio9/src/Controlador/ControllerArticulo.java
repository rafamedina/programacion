package Controlador;


import Modelo.Articulos;
import Vista.Vista;
import Vista.vistaArticulos;

public class ControllerArticulo {
	 private Vista vista;
	    private vistaArticulos vArticulo;
	    private Articulos articulos;
	    public ControllerArticulo() {
	        vista = new Vista();        // Inicializar vista
	        articulos= new Articulos();    // Inicializar cliente
	        vArticulo= new vistaArticulos();
	    }
		public void menuArticulos() {
	        int eleccion; 
	        do {
	            eleccion = vista.menuOperaciones();
	            switch (eleccion) {
	                case 1:
	                	agregarArticulo();
	                    break;
	                case 2:
	                    articulos.mostrarArticulo();
	                    break;
	                case 3:
	                	datosArticulo();
	                    break;
	                case 4:
	                	eliminarArticulo();
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
		public void agregarArticulo() {
	         try {
	        	 String[] datosArticulo = vArticulo.obtenerDatosArticulos();

	        	 String nombre = datosArticulo[0];
	        	 double precio = Double.parseDouble(datosArticulo[1]);
	        	 int stock = Integer.parseInt(datosArticulo[2]);

	        	 articulos.insertarArticulo(nombre, precio, stock);
	             vista.mostrarMensaje("Articulo añadido correctamente.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
		}
		
		
		public void datosArticulo() {
			
			try {
				String buscarNombre=vArticulo.obtenerNombre();
				if(articulos.buscarArticulo(buscarNombre)) {
					String[] nuevosDatos = vArticulo.obtenerDatosArticulos();
					 String nombre = nuevosDatos[0];
		        	 double precio = Double.parseDouble(nuevosDatos[1]);
		        	 int stock = Integer.parseInt(nuevosDatos[2]);
				       articulos.editarArticulo(nombre,precio, stock,buscarNombre);
				            vista.mostrarMensaje("Articulo actualizado.");
					
				}
			
	        } catch(Exception e) {
	            vista.mostrarMensaje("Error" + e.getMessage());
	        }
		}
		
		
		
		public void eliminarArticulo() {
			try {
			 String emailEliminar = vArticulo.obtenerNombre();
			 articulos.eliminarArticulo(emailEliminar);
	             vista.mostrarMensaje("Articulo eliminado.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
	 	}
	}