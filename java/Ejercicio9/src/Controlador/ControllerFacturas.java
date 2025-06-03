package Controlador;

import Modelo.Facturas;
import Vista.vistaFactura;
import Vista.Vista;

public class ControllerFacturas {
	 	private Vista vista;
	    private vistaFactura vFactura;
	    private Facturas factura;
	    public ControllerFacturas() {
	        vista = new Vista();        // Inicializar vista
	        factura= new Facturas();    // Inicializar cliente
	        vFactura= new vistaFactura();
	    }
		public void menuFacturasRecibidas() {
	        int eleccion; 
	        do {
	            eleccion = vista.menuOperaciones();
	            switch (eleccion) {
	                case 1:
	                	agregarFactura();
	                    break;
	                case 2:
	                    factura.mostrarFacturas();
	                    break;
	                case 3:
	                	datosFactura();
	                    break;
	                case 4:
	                	eliminarFactura();
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
		public void agregarFactura() {
	         try {
	        	 String[] datosArticulo = vFactura.obtenerDatosFactura();

	        	 int idP = Integer.parseInt(datosArticulo[0]);
	        	 String fecha = datosArticulo[1];
	        	 double total = Double.parseDouble(datosArticulo[2]);

	        	 factura.insertarFactura(idP, fecha, total);
	             vista.mostrarMensaje("Factura añadido correctamente.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
		}
		
		
		public void datosFactura() {
			
			try {
				int buscarid=vFactura.obtenerid();
				if(factura.buscarFactura(buscarid)) {
					String[] nuevosDatos = vFactura.obtenerDatosFactura();
					int idP = Integer.parseInt(nuevosDatos[0]);
		        	 String fecha = nuevosDatos[1];
		        	 double total = Double.parseDouble(nuevosDatos[2]);
				       factura.editarFactura(idP, fecha, total,buscarid);
				            vista.mostrarMensaje("Factura actualizada.");
					
				}
			
	        } catch(Exception e) {
	            vista.mostrarMensaje("Error" + e.getMessage());
	        }
		}
		
		
		
		public void eliminarFactura() {
			try {
				int idEliminar = vFactura.obtenerid();
			 factura.eliminarFactura(idEliminar);
	             vista.mostrarMensaje("Factura eliminado.");
	         } catch(Exception e) {
	             vista.mostrarMensaje("Error" + e.getMessage());
	         }
	 	}
	}