package GUI;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.ClienteController;
import Controller.ProductoController;
import View.InterfazCliente;
import View.InterfazProducto;

public class GUICliente extends JFrame {
	InterfazCliente interfaz = new InterfazCliente();
	ClienteController clienteC = new ClienteController(interfaz);
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnIA, btnvolver, btnsalir ;
	
	public void  MenuCliente() {
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
        btn1.addActionListener(e -> clienteC.gestionInsertarCliente());

        btn2 = new JButton("Buscar Cliente por ID");
        btn2.setBounds(190, 30, 180, 50);
        btn2.addActionListener(e -> clienteC.gestionBuscarCliente());

        btn3 = new JButton("Todos los Cliente");
        btn3.setBounds(5, 80, 180, 50);
        btn3.addActionListener(e -> clienteC.gestionBuscarClientes());

        btn4 = new JButton("Editar un Cliente");
        btn4.setBounds(190, 80, 180, 50);
        btn4.addActionListener(e -> clienteC.gestionActualizarCliente());
        
        btn5 = new JButton("Eliminar un Cliente");
        btn5.setBounds(5, 130, 180, 50);
        btn5.addActionListener(e -> clienteC.gestionEliminarCliente());
        
        btn6 = new JButton("Buscar por Correo");
        btn6.setBounds(190, 130, 180, 50);
        btn6.addActionListener(e -> clienteC.gestionBuscarPorEmail());
             
        btnsalir = new JButton("Salir");
        btnsalir.setBounds(90, 500, 180, 50);
        btnsalir.addActionListener(e -> setVisible(false));

    }
}
