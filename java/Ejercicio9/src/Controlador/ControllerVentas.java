package Controlador;

import Modelo.Ventas;
import Vista.vistaVentas;
import Vista.Vista;

public class ControllerVentas {
	 	private Vista vista;
	    private vistaVentas vVentas;
	    private Ventas ventas;
	    public ControllerVentas() {
	        vista = new Vista();        // Inicializar vista
	        ventas= new Ventas();    // Inicializar cliente
	        vVentas= new vistaVentas();
	    }
		public void menuVentas() {
	        int eleccion; 
	        do {
	            eleccion = vista.menuOperaciones();
	            switch (eleccion) {
	                case 1:
	                	agregarVenta();
	                    break;
	                case 2:
	                    ventas.mostrarVentas();
	                    break;
	                case 3:
	                	datosVentas();
	                    break;
	                case 4:
	                	eliminarVenta();
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
		public void agregarVenta() {
	         try {
	        	 String[] datosVentas = vVentas.obtenerDatosVentas();

	        	 int idCliente = Integer.parseInt(datosVentas[0]);
	        	 int idProveedor = Integer.parseInt(datosVentas[1]);
	        	 int cantidad = Integer.parseInt(datosVentas[2]);
	        	 String fecha = (datosVentas[2]);

	        	 ventas.insertarVentas(idCliente, idProveedor, cantidad,fecha);
	             vista.mostrarMensaje("Venta añadida correctamente.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
		}
		
		
		public void datosVentas() {
			
			try {
				int buscarid=vVentas.obtenerid();
				if(ventas.buscarVentas(buscarid)) {
					 String[] datosVentas = vVentas.obtenerDatosVentas();

		        	 int idCliente = Integer.parseInt(datosVentas[0]);
		        	 int idProveedor = Integer.parseInt(datosVentas[1]);
		        	 int cantidad = Integer.parseInt(datosVentas[2]);
		        	 String fecha = (datosVentas[2]);
				       ventas.editarVentas(idCliente, idProveedor, cantidad, fecha, buscarid);
				            vista.mostrarMensaje("Factura actualizada.");
					
				}
			
	        } catch(Exception e) {
	            vista.mostrarMensaje("Error" + e.getMessage());
	        }
		}
		
		
		
		public void eliminarVenta() {
			try {
				int idEliminar = vVentas.obtenerid();
			 ventas.eliminarVenta(idEliminar);
	             vista.mostrarMensaje("Factura eliminado.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
	 	}
	}