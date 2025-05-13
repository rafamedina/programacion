
public class Controlador {

	int eleccion;
    public void menuPrincipal() {
    	Vista vista = new Vista();

        do {
            // Menú principal
            System.out.println("----- MENÚ GENERAL -----");
            System.out.println("1 – MENU CLIENTES");
            System.out.println("2 – MENU PROVEEDORES");
            System.out.println("3 – MENU ARTICULOS");
            System.out.println("4 – MENU FACTURAS");
            System.out.println("5 – MENU VENTAS");
            System.out.println("6 – MENU INFORME DE VENTAS POR CLIENTE");
            System.out.println("7 – SALIR");
            this.eleccion = vista.eleccion();
            
            switch (eleccion) {
                case 1:
                    vista.menuCliente();
                    break;
                //case 2:
                   // menuProveedores();
                  //  break;
               // case 3:
                  //  menuArticulos();
                 //   break;
              //  case 4:
                  //  menuFacturas();
                 //   break;
               // case 5:
                  //  menuVentas();
                //    break;
              //  case 6:
                  //  menuVentasXCliente();
                 //   break;
                case 7:
                  System.out.println("SALIENDO...");
                   break;
                default:
                    System.out.println("OPCIÓN INVÁLIDA.");
            }

        } while (eleccion != 7);  // Repite hasta que elija salir

    }
    
    

}
