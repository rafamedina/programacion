package Vista;

import java.util.Scanner;

public class vistaProveedor {
    private Scanner scanner;

    public vistaProveedor() {
        this.scanner = new Scanner(System.in);
    }
    public String obtenerCif() {
        System.out.print("Introduce el cif del proveedor: ");
        return scanner.nextLine();
    }  
    public String[] obtenerDatosProveedor() {
        System.out.print("Introduce el nombre del Proveedor: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el cif del Proveedor: ");
        String cif = scanner.nextLine();
        System.out.print("Introduce el teléfono del Proveedor: ");
        String telefono = scanner.nextLine();
        return new String[]{nombre, cif, telefono};
    }
}
