package Controller;

import javax.swing.*;
import java.awt.event.*;

public class GuiController extends JFrame {
    ProductoController pC = new ProductoController();
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8 ;

    public GuiController() {
        setTitle("Akihabara_Market");
        setSize(400, 400);
        setLocation(650, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        CrearBotones();
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
    }

    public void CrearBotones() {
        btn1 = new JButton("Insertar Cliente");
        btn1.setBounds(5, 30, 180, 50);
        btn1.addActionListener(e -> pC.gestionInsertarCliente());

        btn2 = new JButton("Buscar Producto por ID");
        btn2.setBounds(185, 30, 180, 50);
        btn2.addActionListener(e -> pC.gestionBuscarProducto());

        btn3 = new JButton("Todos los Productos");
        btn3.setBounds(5, 80, 180, 50);
        btn3.addActionListener(e -> pC.gestionBuscarProductos());

        btn4 = new JButton("Editar un Producto");
        btn4.setBounds(185, 80, 180, 50);
        btn4.addActionListener(e -> pC.gestionActualizarProducto());
    }
 
    
}
