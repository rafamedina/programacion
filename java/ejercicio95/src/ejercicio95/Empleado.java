package ejercicio95;
import java.io.Serializable;
import java.io.*;
import java.util.Scanner;

public class Empleado implements Serializable {
    String nombre;
    int edad;
    int salario;
    Scanner scanner = new Scanner(System.in);

    public Empleado(String nombre, int edad, int salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public void añadirEmpleado() {
        try {
            String nombre1;
            int edad1;
            int salario1;
            System.out.println("Dime el nombre: ");
            nombre1 = scanner.nextLine();  

            System.out.println("Dime la edad: ");
            edad1 = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Dime el salario: ");
            salario1 = scanner.nextInt();
            scanner.nextLine(); 

            Empleado empleado = new Empleado(nombre1, edad1, salario1);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("empleado.ser"));
            out.writeObject(empleado);
            out.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error guardando el objeto: " + e.getMessage());
        }
    }


    public void mostrarEmpleado() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("empleado.ser"));
            Empleado empleadoRecuperado = (Empleado) in.readObject();
            in.close();
            System.out.println("Datos recuperados:");
            System.out.println("Nombre: " + empleadoRecuperado.nombre);
            System.out.println("Edad: " + empleadoRecuperado.edad);
            System.out.println("Salario: " + empleadoRecuperado.salario);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error leyendo el objeto: " + e.getMessage());
        }
    }

    public void Menu() {
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("Opción 1: Añadir un Empleado");
            System.out.println("Opción 2: Mostrar Empleados");
            System.out.println("Opción 3: Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    añadirEmpleado();
                    break; // Se añade break para que no siga ejecutando el siguiente caso
                case 2:
                    mostrarEmpleado();
                    break; // Se añade break para evitar que pase al siguiente caso
                case 3:
                    System.out.println("Adiós");
                    break; // Salir del menú
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3); // El bucle sigue hasta que se elige la opción 3
    }
}

  







