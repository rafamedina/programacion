package Controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DAO.ProductoDAO;
import View.InterfazProducto;


public class ControllerGeneral extends JFrame {
	ProductoController Pcontroller = new ProductoController();
	ClienteController Ccontroller = new ClienteController();
	InterfazProducto interfaz = new InterfazProducto();
	ProductoDAO productodao = new ProductoDAO();
	JFrame principal = new JFrame();
	JButton btn1, btn2, btnsalir;
	public ControllerGeneral() {
		
		 setTitle("AKIHABARA MARKET");
	        setSize(400, 400);
	        setLocation(650, 250);
	        setLayout(null); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE);

	        
	        btn1 = new JButton("Menu Producto");
	        btn1.setBounds(50, 50, 150, 50);
	        btn1.addActionListener(e -> Pcontroller.MenuProducto());
	        add(btn1);
	        
	        btn2 = new JButton("Menu Cliente");
	        btn2.setBounds(250, 50, 150, 50);
	        btn2.addActionListener(e -> Ccontroller.MenuCliente());
	        add(btn2);
	        
	        btnsalir = new JButton("Salir");
	        btnsalir.setBounds(250, 150, 150, 50);
	        btnsalir.addActionListener(e -> setVisible(false));
	        add(btnsalir);
	}

}