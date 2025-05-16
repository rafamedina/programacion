package Vista;
import java.util.Scanner;
public class vistaFactura {
    private Scanner scanner;

    public vistaFactura() {
        this.scanner = new Scanner(System.in);
    }
    public String[] obtenerDatosFactura() {
        System.out.print("Introduce el id del proveedor: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce la fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("Introduce el total: ");
        String total = scanner.nextLine();
        return new String[]{nombre, fecha, total};
    }
    public int obtenerid() {
        System.out.print("Introduce el ID de la factura: ");
        int id = scanner.nextInt();
        return  id;
    }
}