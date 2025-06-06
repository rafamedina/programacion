package Controller;
import java.awt.Component;
import java.sql.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import DAO.*;
import Model.ClienteOtaku;
import Model.LlmService;
import Model.ProductoOtaku;
import View.*;
public class ClienteController extends JFrame {
	ClienteDAO clientedao = new ClienteDAO();
	InterfazConsolaCliente interfaz = new InterfazConsolaCliente();
	 JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnIA, btnvolver, btnsalir ;
	public void MenuCliente() {
        setTitle("Akihabara_Market");
        setSize(500, 700);
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
        add(btnsalir);
        
      
        Component salida = interfaz.crearCampoSalida();
		
	    add(salida);
	    setVisible(true);
    }

    public void CrearBotones() {
        btn1 = new JButton("Insertar Cliente");
        btn1.setBounds(5, 30, 180, 50);
        btn1.addActionListener(e -> gestionInsertarCliente());

        btn2 = new JButton("Buscar Cliente por ID");
        btn2.setBounds(190, 30, 180, 50);
        btn2.addActionListener(e -> gestionBuscarCliente());

        btn3 = new JButton("Todos los Cliente");
        btn3.setBounds(5, 80, 180, 50);
        btn3.addActionListener(e -> gestionBuscarClientes());

        btn4 = new JButton("Editar un Cliente");
        btn4.setBounds(190, 80, 180, 50);
        btn4.addActionListener(e -> gestionActualizarCliente());
        
        btn5 = new JButton("Eliminar un Cliente");
        btn5.setBounds(5, 130, 180, 50);
        btn5.addActionListener(e -> gestionEliminarCliente());
        
        btn6 = new JButton("Buscar por Nombre");
        btn6.setBounds(190, 130, 180, 50);
        btn6.addActionListener(e -> gestionBuscarPorEmail());
             
        btnsalir = new JButton("Salir");
        btnsalir.setBounds(90, 500, 180, 50);
        btnsalir.addActionListener(e -> setVisible(false));

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

	public void gestionBuscarPorEmail() {
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

	

