package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Display extends JFrame{
	JFrame d;
	JButton btn1;
	
	public Display() {
		btn1 = new JButton();
		d = new JFrame(); // Creamos la "app"
		d.setVisible(true); // Para que el formaulario sea visible
		d.setBounds(650, 250, 400, 400); // Ajustamos el tamaño de nuestra pantalla, en orden: (coordenada x, coordeanda y(para donde aparece la pantalla), alto, ancho)
		d.setDefaultCloseOperation(EXIT_ON_CLOSE);//Indicamos que cuando se cierre la ventana se termine la ejecucion
		d.setLayout(null); // Mirar que hace
		d.setTitle("Aqui va el titulo");
		// Con esto tendrias creado tu pantalla	
		
		
		
		
		
		btn1.setBounds(5, 30, 200, 50);
		btn1.setText("Aqui va el texto del boton"); // Texto del Boton
		btn1.setBackground(Color.pink); // Cambiar el color del boton
		
		
		btn1.addActionListener(new ActionListener() { // CON ESTO AÑADES QUE QUIERES QUE HAGA EL BOTON

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.err.println("Que te follen ");
			}
			
		});
		d.add(btn1); // Con esto agregamos el boton a nuestro panel
	}

}