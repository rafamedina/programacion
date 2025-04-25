package ejercicio92;

import java.io.Serializable;

public class Animal  implements Serializable {
	String nombre;
	String especie;
	public Animal(String nombre,String especie) {
		try {
		this.nombre=nombre;
		this.especie=especie;
		} catch(Exception e) {
			System.out.println("No se puede crear el objeto");
		}
	}

}
