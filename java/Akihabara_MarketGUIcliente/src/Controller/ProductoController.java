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
public class ProductoController extends JFrame{
	ProductoDAO productodao = new ProductoDAO();
	InterfazProducto interfaz = new InterfazProducto();
	LlmService ia = new LlmService();
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnIA, btnvolver, btnsalir ;

	    public void MenuProducto() {
	        setTitle("Akihabara_Market");
	        setSize(400, 700);
	        setLocation(650, 250);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	        
	        CrearBotones();
	        add(btn1);
	        add(btn2);
	        add(btn3);
	        add(btn4);
	        add(btn5);
	        add(btn6);
	        add(btnIA);
	        add(btnsalir);
	        
	      
	        Component salida = interfaz.createFieldSalida();
			
		    add(salida);
		    setVisible(true);
	    }

	    public void CrearBotones() {
	        btn1 = new JButton("Insertar Producto");
	        btn1.setBounds(5, 30, 180, 50);
	        btn1.addActionListener(e -> gestionInsertarCliente());

	        btn2 = new JButton("Buscar Producto por ID");
	        btn2.setBounds(190, 30, 180, 50);
	        btn2.addActionListener(e -> gestionBuscarProducto());

	        btn3 = new JButton("Todos los Productos");
	        btn3.setBounds(5, 80, 180, 50);
	        btn3.addActionListener(e -> gestionBuscarProductos());

	        btn4 = new JButton("Editar un Producto");
	        btn4.setBounds(190, 80, 180, 50);
	        btn4.addActionListener(e -> gestionActualizarProducto());
	        
	        btn5 = new JButton("Eliminar un Producto");
	        btn5.setBounds(5, 130, 180, 50);
	        btn5.addActionListener(e -> gestionEliminarProducto());
	        
	        btn6 = new JButton("Buscar por Nombre");
	        btn6.setBounds(190, 130, 180, 50);
	        btn6.addActionListener(e -> gestionBuscarPorNombre());
	        
	        btnIA = new JButton("Menu IA");
	        btnIA.setBounds(90, 190, 180, 50);
	        btnIA.addActionListener(e -> crearPanelIa());
	        
	        btnsalir = new JButton("Salir");
	        btnsalir.setBounds(90, 500, 180, 50);
	        btnsalir.addActionListener(e -> setVisible(false));

	    }
	

	public void crearPanelIa() {
		JFrame pIa = new JFrame();
		pIa.setTitle("Menu IA");
		pIa.setSize(400, 200);
		pIa.setLocation(650, 250);
		pIa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pIa.setLayout(null);
        btn7 = new JButton("Descripcion IA");
        btn7.setBounds(5, 30, 180, 50);
        btn7.addActionListener(e -> descripcionIA());

        btn8 = new JButton("Sugerir Categoria");
        btn8.setBounds(185, 30, 180, 50);
        btn8.addActionListener(e -> categoriaIA());
        
        btnvolver = new JButton("Volver");
        btnvolver.setBounds(90, 90, 180, 50);
        btnvolver.addActionListener(e -> pIa.setVisible(false));
        
        pIa.add(btn7);
        pIa.add(btn8);
        pIa.add(btnvolver);
		pIa.setVisible(true);
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
	

