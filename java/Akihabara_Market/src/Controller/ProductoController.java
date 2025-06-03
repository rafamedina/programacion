package Controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import DAO.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Model.LlmService;
import Model.ProductoOtaku;
import View.*;
public class ProductoController extends JFrame{
	ProductoDAO productodao = new ProductoDAO();
	InterfazConsola interfaz = new InterfazConsola();
	LlmService ia = new LlmService();
	JFrame d;
	JButton btn1;
	JButton btn2;
	

	public void GUIMenu() {
		
		d = new JFrame();
		btn1 = new JButton();
		btn2 = new JButton();
		d.setVisible(true); // Para que el formaulario sea visible
		d.setBounds(650, 250, 400, 400); // Ajustamos el tamaño de nuestra pantalla, en orden: (coordenada x, coordeanda y(para donde aparece la pantalla), alto, ancho)
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);//Indicamos que cuando se cierre la ventana se termine la ejecucion
		d.setLayout(null); // Mirar que hace
		d.setTitle("Akihabara_Market");
		
		btn1.setBounds(5, 30, 200, 50);
		btn1.setText("Insertar Cliente"); // Texto del Boton
		btn1.setBackground(Color.pink);
		btn1.addActionListener(new ActionListener() { // CON ESTO AÑADES QUE QUIERES QUE HAGA EL BOTON			
			@Override
			public void actionPerformed(ActionEvent e) {
				gestionInsertarCliente();
			}			
		});	
		btn2.setBounds(5, 80, 200, 50);
		btn2.setText("Buscar Producto"); // Texto del Boton
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gestionBuscarProducto();
			}	
		});	
		d.add(btn1); // Con esto agregamos el boton a nuestro panel
		d.add(btn2);
		}
	
	
	
	public void gestionMenu() {
	    // Cargamos productos de prueba al iniciar la aplicación
	    SetupDatos.cargarProductosIniciales(productodao);

	    int eleccion;

	    do {
	        // Muestro el menú principal al usuario y guardo su elección
	        eleccion = interfaz.Menu();

	        switch (eleccion) {
	            case 1:
	                // Inserto un producto nuevo
	                gestionInsertarCliente();
	                break;
	            case 2:
	                // Busco un producto por ID
	                gestionBuscarProducto();
	                break;
	            case 3:
	                // Muestro todos los productos
	                gestionBuscarProductos();
	                break;
	            case 4:
	                // Actualizo un producto existente
	                gestionActualizarProducto();
	                break;
	            case 5:
	                // Elimino un producto por ID
	                gestionEliminarProducto();
	                break;
	            case 6:
	                // Busco productos por nombre
	                gestionBuscarPorNombre();
	                break;
	            case 7:
	                // Submenú con ayuda de IA
	                int eleccion2;
	                do {
	                    eleccion2 = interfaz.menuIA();

	                    switch (eleccion2) {
	                        case 1:
	                            descripcionIA();
	                            break;
	                        case 2:
	                        	categoriaIA();
	                            break;
	                        case 3:
	                            System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
	                            break;
	                        default:
	                            System.out.println("OPCION IA NO VALIDA");
	                            break;
	                    }
	                } while (eleccion2 != 3); // Repite hasta que el usuario quiera volver al menú principal
	                break;

	            case 8:
	                System.out.println("SALIENDO DEL MENU...");
	                break;
	            default:
	                System.out.println("OPCION NO VALIDA");
	                break;
	        }

	    } while (eleccion != 8); // El bucle termina cuando el usuario elige salir
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
	
	public void descripcionIA() {
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
	

