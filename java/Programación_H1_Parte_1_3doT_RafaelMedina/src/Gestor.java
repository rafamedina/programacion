import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    static ArrayList<Animal> animales = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

 // Con este método añado un nuevo animal a la lista, siempre y cuando no haya otro con el mismo número de chip.
 // Primero pido el chip, reviso si ya existe, y luego pregunto si se trata de un perro o un gato.
 // Dependiendo del tipo, llamo al método correspondiente para crearlo y lo añado a la lista.
 public static void añadirAnimales() {
     System.out.print("Introduce el chip del animal: ");
     int numerochip = scanner.nextInt();
     scanner.nextLine();  

     for (Animal a : animales) {
         if (a.getNumerochip() == numerochip) {
             System.out.println(" Ya existe un animal con ese chip. No se ha añadido.");
             return;
         }
     }

     System.out.print("¿Es un Perro o un Gato? ");
     String tipo = scanner.nextLine().toLowerCase();

     if (tipo.equals("perro")) {
         Animal nuevo = Perro.añadirPerro(numerochip, scanner);
         if (nuevo != null) {
             animales.add(nuevo);
             System.out.println("¡Animal añadido correctamente!");
         }
     } else if (tipo.equals("gato")) {
         Animal nuevo = Gato.añadirGato(numerochip, scanner);
         if (nuevo != null) {
             animales.add(nuevo);
             System.out.println("¡Animal añadido correctamente!");
         }
     } else {
         System.out.println("Tipo no válido.");
     }
 }

 // Este método me permite buscar un animal por su número de chip.
 // Recorro la lista, y si lo encuentro, llamo al método mostrar() de ese animal.
 // Si no lo encuentro, informo al usuario.
 public static void buscarAnimales() {
     System.out.println("Introduce el número de chip que quieras buscar: ");
     int chipbuscar = scanner.nextInt();
     boolean encontrado = false;

     for (Animal a : animales) {
         if (a.getNumerochip() == chipbuscar) {
             a.mostrar();
             encontrado = true;
             break;
         }
     }

     if (!encontrado) {
         System.out.println(" No se ha encontrado ningún animal con ese chip.");
     }
 }

}


