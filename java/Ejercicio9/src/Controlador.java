public class Controlador {

    private Vista vista;
    private Clientes cliente;
//    private Proveedores proveedor;
//    private Articulos articulo;
//    private Ventas venta;
//    private FacturasRecibidas facturaRecibida;

    public Controlador() {
        this.vista = new Vista();
        this.cliente = new Clientes();
//        this.proveedor = new Proveedores();
//        this.articulo = new Articulos();
//        this.venta = new Ventas();
//        this.facturaRecibida = new FacturasRecibidas();
    }

    public void menuPrincipal() {
        int eleccion;
        do {
            eleccion = vista.menuPrincipal();  // Obtener opción del menú
            switch (eleccion) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuProveedores();
                    break;
                case 3:
                    menuArticulos();
                    break;
                case 4:
                    menuVentas();
                    break;
                case 5:
                    menuFacturasRecibidas();
                    break;
                case 6:
                    vista.mostrarMensaje("SALIENDO...");
                    break;
                default:
                    vista.mostrarMensaje("OPCIÓN INVÁLIDA.");
            }
        } while (eleccion != 6); // Repite hasta que elija salir
    }

    public void menuClientes() {
        int eleccion;
        do {
            eleccion = vista.menuClientes();
            switch (eleccion) {
                case 1:
                    String[] datosCliente = vista.obtenerDatosCliente();
                    if (cliente.insertarCliente(datosCliente[0], datosCliente[1], datosCliente[2])) {
                        vista.mostrarMensaje("Cliente añadido correctamente.");
                    } else {
                        vista.mostrarMensaje("Error al añadir cliente.");
                    }
                    break;
                case 2:
                    cliente.mostrarClientes();
                    break;
                case 3:
                    String[] nuevosDatos = vista.obtenerDatosCliente();
                    if (cliente.editarCliente(nuevosDatos[0], nuevosDatos[2], nuevosDatos[1])) {
                        vista.mostrarMensaje("Cliente actualizado.");
                    } else {
                        vista.mostrarMensaje("Error al editar cliente.");
                    }
                    break;
                case 4:
                    String emailEliminar = vista.obtenerCorreo();
                    if (cliente.eliminarCliente(emailEliminar)) {
                        vista.mostrarMensaje("Cliente eliminado.");
                    } else {
                        vista.mostrarMensaje("Error al eliminar cliente.");
                    }
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida.");
            }
        } while (eleccion != 5);
    }

    public void menuProveedores() {
        // Lógica para manejar los proveedores
    }

    public void menuArticulos() {
        // Lógica para manejar los artículos
    }

    public void menuVentas() {
        // Lógica para manejar las ventas
    }

    public void menuFacturasRecibidas() {
        // Lógica para manejar las facturas recibidas
    }
}


