import java.util.Scanner;

public class Perro extends Animal {

    private String tamaño;

 // Este es el constructor del Perro, aquí recibo todos los datos del animal y además su tamaño.
 // Verifico si el tamaño es válido (pequeño, mediano o grande) antes de asignarlo.
 // Si no lo es, lanzo un error para evitar crear un objeto con un valor incorrecto.
 public Perro(int numerochip, String nombre, int edad, String raza, boolean adoptado, String tamaño) {
     super(numerochip, nombre, edad, raza, adoptado);

     String tamañoMinus = tamaño.toLowerCase();

     if (tamañoMinus.equals("pequeño") || tamañoMinus.equals("mediano") || tamañoMinus.equals("grande")) {
         this.tamaño = tamañoMinus;
     } else {
         throw new IllegalArgumentException("Tamaño inválido. Debe ser: pequeño, mediano o grande.");
     }
 }

 // Con este método muestro por pantalla todos los datos del perro.
 // Incluyo también el tamaño y muestro si está adoptado de forma legible (Sí o No).
 @Override
 public void mostrar() {
     System.out.println("Perro:");
     System.out.println("Chip: " + numerochip);
     System.out.println("Nombre: " + nombre);
     System.out.println("Edad: " + edad);
     System.out.println("Raza: " + raza);
     System.out.println("Adoptado: " + (adoptado ? "Sí" : "No"));
     System.out.println("Tamaño: " + tamaño);
 }

 // Este método me sirve para crear un nuevo objeto Perro desde el menú, pidiendo los datos por teclado.
 // Valido el tamaño, y si es incorrecto, muestro un mensaje de error y devuelvo null.
 public static Perro añadirPerro(int numerochip, Scanner scanner) {
     System.out.print("Introduce el nombre del perro: ");
     String nombre = scanner.nextLine();

     System.out.print("Introduce la edad: ");
     int edad = scanner.nextInt();
     scanner.nextLine(); 

     System.out.print("Introduce la raza: ");
     String raza = scanner.nextLine();

     System.out.print("¿Está adoptado? true/false: ");
     boolean adoptado = scanner.nextBoolean();
     scanner.nextLine(); 

     System.out.print("¿Qué tamaño tiene? (pequeño, mediano, grande): ");
     String tamaño = scanner.nextLine();

     try {
         return new Perro(numerochip, nombre, edad, raza, adoptado, tamaño);
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
         return null;
     }
 }



}

