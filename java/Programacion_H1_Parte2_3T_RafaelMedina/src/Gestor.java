import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    static ArrayList<Animal> animales = new ArrayList<>();
    static ArrayList<Adopcion> adopciones = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

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


    public static void listarAnimales() {
        for (Animal animal : animales) {
            animal.mostrar();
        }
    }

    public static void buscarAnimales() {
        System.out.print("Introduce el chip del animal a buscar: ");
        int chipbuscar = scanner.nextInt();
        scanner.nextLine();

        boolean encontrado = false;
        for (Animal a : animales) {
            if (a.getNumerochip() == chipbuscar) {
                a.mostrar();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un animal con ese chip.");
        }
    }

    public static void realizarAdopcion() {
        System.out.print("Introduce el chip del animal a adoptar: ");
        int chip = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        Animal animal = null;
        for (Animal a : animales) {
            if (a.getNumerochip() == chip && !a.adoptado) {
                animal = a;
                break;
            }
        }

        if (animal == null) {
            System.out.println("El animal no está disponible para adopción o ya ha sido adoptado.");
            return;
        }

        System.out.print("Introduce el nombre del adoptante: ");
        String nombreAdoptante = scanner.nextLine();
        System.out.print("Introduce el DNI del adoptante: ");
        String dniAdoptante = scanner.nextLine();

        // Registrar la adopción en la lista de adopciones
        Adopcion adopcion = new Adopcion(animal, nombreAdoptante, dniAdoptante);
        adopciones.add(adopcion);
        animal.adoptado = true;

        System.out.println("¡Adopción realizada con éxito!");
    }


    public static void darDeBaja() {
        System.out.print("Introduce el chip del animal a dar de baja: ");
        int chip = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea

        Animal animal = null;
        for (Animal a : animales) {
            if (a.getNumerochip() == chip) {
                animal = a;
                break;
            }
        }

        if (animal == null) {
            System.out.println("No se encontró un animal con ese chip.");
            return;
        }

        // Eliminar la adopción si el animal estaba adoptado
        for (int i = 0; i < adopciones.size(); i++) {
            if (adopciones.get(i).getAnimal().equals(animal)) {
                adopciones.remove(i);
                break;
            }
        }

        animales.remove(animal);
        System.out.println("¡Animal dado de baja correctamente!");
    }



    public static void mostrarEstadisticasGatos() {
        int totalGatos = 0;
        int gatosConLeucemia = 0;
        int gatosAdoptados = 0;

        for (Animal animal : animales) {
            if (animal instanceof Gato) {
                totalGatos++;  // Contamos el gato
                if (((Gato) animal).testleucemia) {
                    gatosConLeucemia++;
                }

                // Comprobamos si el gato ha sido adoptado
                if (animal.adoptado) {
                    gatosAdoptados++;
                }
            }
        }

        System.out.println("Número total de gatos: " + totalGatos);
        System.out.println("Número de gatos con leucemia: " + gatosConLeucemia);
        System.out.println("Número de gatos adoptados: " + gatosAdoptados);
        System.out.println("Número de gatos no adoptados: " + (totalGatos - gatosAdoptados));
    }
}



