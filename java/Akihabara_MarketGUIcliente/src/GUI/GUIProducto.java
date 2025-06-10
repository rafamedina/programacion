package GUI;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import Controller.ProductoController;
import DAO.ProductoDAO;
import View.InterfazProducto;

public class GUIProducto extends JFrame{
	InterfazProducto interfaz = new InterfazProducto();
	ProductoController productoC = new ProductoController(interfaz);
	JProgressBar progressBar;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnIA, btnvolver, btnsalir ;

    public void MenuProducto() {
        setTitle("Productos");
        setSize(800, 800);
        setLocation(500, 100);
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
        Component tabla = interfaz.crearTablaProductos();
		add(tabla);
	    add(salida);
	    setVisible(true);
    }

    public void CrearBotones() {

    	
        btn1 = new JButton("Insertar Producto");
        btn1.setBounds(405, 30, 180, 50);
        btn1.addActionListener(e -> productoC.gestionInsertarCliente());

        btn2 = new JButton("Buscar Producto por ID");
        btn2.setBounds(190, 30, 180, 50);
        btn2.addActionListener(e -> productoC.gestionBuscarProducto());

        btn3 = new JButton("Todos los Productos");
        btn3.setBounds(405, 80, 180, 50);
        btn3.addActionListener(e -> productoC.gestionBuscarProductos());

        btn4 = new JButton("Editar un Producto");
        btn4.setBounds(190, 80, 180, 50);
        btn4.addActionListener(e -> productoC.gestionActualizarProducto());
        
        btn5 = new JButton("Eliminar un Producto");
        btn5.setBounds(405, 130, 180, 50);
        btn5.addActionListener(e -> productoC.gestionEliminarProducto());
        
        btn6 = new JButton("Buscar por Nombre");
        btn6.setBounds(190, 130, 180, 50);
        btn6.addActionListener(e -> productoC.gestionBuscarPorNombre());
        
        btnIA = new JButton("Menu IA");
        btnIA.setBounds(290, 190, 180, 50);
        btnIA.addActionListener(e -> crearPanelIa());
        
        btnsalir = new JButton("Salir");
        btnsalir.setBounds(300, 700, 180, 50);
        btnsalir.addActionListener(e -> setVisible(false));

    }

    public void crearPanelIa() {
        JFrame pIa = new JFrame();
        pIa.setTitle("Menu IA");
        pIa.setSize(400, 250);
        pIa.setLocation(700, 400);
        pIa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pIa.setLayout(null);

        // Barra de progreso
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(90, 145, 180, 25);
        progressBar.setStringPainted(true);
        pIa.add(progressBar);

        // Botón Descripción IA
        btn7 = new JButton("Descripcion IA");
        btn7.setBounds(5, 30, 180, 50);
        btn7.addActionListener(e -> {
            int id = interfaz.pedirId();
            if (id <= 0) return;

            btn7.setEnabled(false);
            btn8.setEnabled(false);

            Thread hiloIA = new Thread(() -> {
                final String[] respuestaIA = new String[1];

                // Hilo 1: hacer la petición a la IA (pero sin mostrar nada aún)
                Thread iaThread = new Thread(() -> {
                    respuestaIA[0] = productoC.generarDescripcionIAyRetornar(id); // nuevo método
                });

                // Hilo 2: barra de carga lineal
                Thread barra = new Thread(() -> {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setValue(i);
                        try {
                            Thread.sleep(30); // Duración total de 3s
                        } catch (InterruptedException ex) {
                            return;
                        }
                    }
                });

                iaThread.start();
                barra.start();

                try {
                    iaThread.join(); // Espera IA
                    barra.join();    // Espera barra
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Mostrar mensaje al terminar todo
                interfaz.mostrarMensaje("IA: " + respuestaIA[0]);
                progressBar.setValue(0);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
            });

            hiloIA.start();
        });

        // Botón Categoría IA
        btn8 = new JButton("Sugerir Categoria");
        btn8.setBounds(185, 30, 180, 50);
        btn8.addActionListener(e -> {
            String nombre = interfaz.pedirNombre();
            if (nombre == null || nombre.trim().isEmpty()) return;

            btn7.setEnabled(false);
            btn8.setEnabled(false);

            Thread hiloIA = new Thread(() -> {
                final String[] respuestaIA = new String[1];

                Thread iaThread = new Thread(() -> {
                    respuestaIA[0] = productoC.generarCategoriaIAyRetornar(nombre); // nuevo método
                });

                Thread barra = new Thread(() -> {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setValue(i);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            return;
                        }
                    }
                });

                iaThread.start();
                barra.start();

                try {
                    iaThread.join();
                    barra.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                interfaz.mostrarMensaje("IA: " + respuestaIA[0]);
                progressBar.setValue(0);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
            });

            hiloIA.start();
        });

        // Botón Volver
        btnvolver = new JButton("Volver");
        btnvolver.setBounds(90, 90, 180, 50);
        btnvolver.addActionListener(e -> pIa.setVisible(false));

        pIa.add(btn7);
        pIa.add(btn8);
        pIa.add(btnvolver);

        pIa.setVisible(true);
    }


}