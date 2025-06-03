package Controller;
import Model.ProductoOtaku;
import java.util.List;
import DAO.ProductoDAO;

	public class SetupDatos {

	    public static void cargarProductosIniciales(ProductoDAO dao) {
	        List<ProductoOtaku> productos = dao.obtenerTodosLosProductos();

	        if (productos.isEmpty()) {
	            System.out.println("Insertando productos iniciales...");

	            ProductoOtaku p1 = new ProductoOtaku(0, "Figura de Itachi Uchiha", "Figura", 59.95, 8);
	            ProductoOtaku p2 = new ProductoOtaku(0, "Manga Berserker Vol.1", "Manga", 9.99, 20);
	            ProductoOtaku p3 = new ProductoOtaku(0, "Póster Solo Leveling", "Póster", 15.50, 15);

	            dao.AgregarProducto(p1);
	            dao.AgregarProducto(p2);
	            dao.AgregarProducto(p3);

	            System.out.println("Productos iniciales insertados correctamente.");
	        } else {
	            System.out.println("Ya hay productos en la base de datos. No se insertó nada.");
	        }
	    }
	}
