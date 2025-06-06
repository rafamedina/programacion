package GUI;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controller.ProductoController;
import DAO.ProductoDAO;
import View.InterfazProducto;

public class GUIProducto extends JFrame{
	InterfazProducto interfaz = new InterfazProducto();
	ProductoController productoC = new ProductoController(interfaz);

	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnIA, btnvolver, btnsalir ;

    public void MenuProducto() {
        setTitle("Productos");
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
        btn1.addActionListener(e -> productoC.gestionInsertarCliente());

        btn2 = new JButton("Buscar Producto por ID");
        btn2.setBounds(190, 30, 180, 50);
        btn2.addActionListener(e -> productoC.gestionBuscarProducto());

        btn3 = new JButton("Todos los Productos");
        btn3.setBounds(5, 80, 180, 50);
        btn3.addActionListener(e -> productoC.gestionBuscarProductos());

        btn4 = new JButton("Editar un Producto");
        btn4.setBounds(190, 80, 180, 50);
        btn4.addActionListener(e -> productoC.gestionActualizarProducto());
        
        btn5 = new JButton("Eliminar un Producto");
        btn5.setBounds(5, 130, 180, 50);
        btn5.addActionListener(e -> productoC.gestionEliminarProducto());
        
        btn6 = new JButton("Buscar por Nombre");
        btn6.setBounds(190, 130, 180, 50);
        btn6.addActionListener(e -> productoC.gestionBuscarPorNombre());
        
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
    btn7.addActionListener(e -> productoC.descripcionIA());

    btn8 = new JButton("Sugerir Categoria");
    btn8.setBounds(185, 30, 180, 50);
    btn8.addActionListener(e -> productoC.categoriaIA());
    
    btnvolver = new JButton("Volver");
    btnvolver.setBounds(90, 90, 180, 50);
    btnvolver.addActionListener(e -> pIa.setVisible(false));
    
    pIa.add(btn7);
    pIa.add(btn8);
    pIa.add(btnvolver);
	pIa.setVisible(true);
}
}
