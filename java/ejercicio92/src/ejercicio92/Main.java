package ejercicio92;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal = new Animal("Bobi","Perro");
		
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("animal.ser"));
            out.writeObject(animal);
            out.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error guardando el objeto: " + e.getMessage());
        }

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("animal.ser"));
            Animal animalRecuperada = (Animal) in.readObject();
            in.close();
            System.out.println("Datos recuperados:");
            System.out.println("Nombre: " + animalRecuperada.nombre);
            System.out.println("Especie: " + animalRecuperada.especie);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo el objeto: " + e.getMessage());
        }
    }
}

