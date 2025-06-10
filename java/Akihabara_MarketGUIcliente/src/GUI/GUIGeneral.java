package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.ClienteController;
import Controller.ProductoController;
import DAO.ProductoDAO;
import View.InterfazProducto;


public class GUIGeneral extends JFrame {
	GUICliente cliente = new GUICliente();
	InterfazProducto interfaz = new InterfazProducto();
	ProductoDAO productodao = new ProductoDAO();
	GUIProducto producto = new GUIProducto();
	JFrame principal = new JFrame();
	JButton btn1, btn2, btnsalir;
	public GUIGeneral() {
		
		 setTitle("AKIHABARA MARKET");
	        setSize(400, 300);
	        setLocation(650, 250);
	        setLayout(null); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE);

	        
	        btn1 = new JButton("Menu Producto");
	        btn1.setBounds(35, 50, 150, 50);
	        btn1.addActionListener(e -> producto.MenuProducto());
	        add(btn1);
	        
	        btn2 = new JButton("Menu Cliente");
	        btn2.setBounds(220, 50, 150, 50);
	        btn2.addActionListener(e -> cliente.MenuCliente());
	        add(btn2);
	        
	        btnsalir = new JButton("Salir");
	        btnsalir.setBounds(125, 150, 150, 50);
	        btnsalir.addActionListener(e -> setVisible(false));
	        add(btnsalir);
	}

}