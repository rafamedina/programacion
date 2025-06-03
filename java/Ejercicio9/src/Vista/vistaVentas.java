package Vista;

import java.util.Scanner;

public class vistaVentas {
	private Scanner scanner;

    public vistaVentas() {
        this.scanner = new Scanner(System.in);
    }
    public String[] obtenerDatosVentas() {
        System.out.print("Introduce el id del cliente: ");
        String cliente = scanner.nextLine();
        System.out.print("Introduce el id del articulo: ");
        String articulo = scanner.nextLine();
        System.out.print("Introduce la cantidad: ");
        String cantidad = scanner.nextLine();
        System.out.print("Introduce la fecha: ");
        String fecha = scanner.nextLine();
        return new String[]{cliente, articulo, cantidad,fecha};
    }
    public int obtenerid() {
        System.out.print("Introduce el ID de la Venta: ");
        int id = scanner.nextInt();
        return  id;
    }
}
