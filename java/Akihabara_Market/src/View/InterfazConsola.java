package View;
import java.util.List;
import java.util.Scanner;

import Model.ProductoOtaku;

public class InterfazConsola {
Scanner scanner = new Scanner(System.in);

	public int leerEntero(String mensaje) {
	    int numero = -1;
	    boolean valido = false;
	
	    while (!valido) {
	        System.out.print(mensaje);
	        String entrada = scanner.nextLine();
	        try {
	            numero = Integer.parseInt(entrada);
	            if (numero < 0) {
	                System.out.println("Debe ser un número entero positivo.");
	            } else {
	                valido = true;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. Debes escribir un número entero.");
	        }
	    }
	
	    return numero;
	}
	
	public double leerDecimal(String mensaje) {
	    double numero = -1;
	    boolean valido = false;

	    while (!valido) {
	        System.out.print(mensaje);
	        String entrada = scanner.nextLine();
	        try {
	            numero = Double.parseDouble(entrada);
	            if (numero < 0) {
	                System.out.println("Debe ser un número decimal positivo.");
	            } else {
	                valido = true;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("Entrada inválida. Debes escribir un número decimal.");
	        }
	    }

	    return numero;
	}


	 public int pedirId() {
	        return leerEntero("Que id quieres editar: ");
	    }
	 
	public String pedirEdicion() {
	    String[] opcionesValidas = {"nombre", "categoria", "precio", "stock", "todo"};
	    String seleccion;

	    System.out.println("¿Qué parte quieres modificar? (nombre, categoria, precio, stock, todo)");
	    System.out.println("Escribe 'salir' para cancelar.");

	    while (true) {
	        System.out.print("Selecciona una opción: ");
	        seleccion = scanner.nextLine().toLowerCase();

	        if (seleccion.equals("salir")) {
	            System.out.println("Edición cancelada.");
	            return null;
	        }

	        for (String opcion : opcionesValidas) {
	            if (opcion.equals(seleccion)) {
	                return seleccion;
	            }
	        }

	        System.out.println("Opción no válida. Intenta de nuevo.");
	    }
	}
	
		public String pedirNombre() {
		    System.out.print("Dime el nombre: ");
		    String nombre = scanner.nextLine().trim();
	
		    if (nombre != null && !nombre.isEmpty()) {
		        return nombre;
		    } else {
		        System.out.println("El nombre no puede estar vacío.");
		        return pedirNombre();
		    }
		}
		
		public String pedirCategoria() {
		    System.out.print("Dime la categoria: ");
		    String categoria = scanner.nextLine().trim();
	
		    if (categoria != null && !categoria.isEmpty()) {
		        return categoria;
		    } else {
		        System.out.println("la categoria no puede estar vacía.");
		        return pedirCategoria();
		    }
		}


	    public double pedirPrecio() {
	        return leerDecimal("Que precio nuevo quieres poner: ");
	    }

	    public int pedirStock() {
	        return leerEntero("Que stock nuevo quieres poner: ");
	    }

	    public int eleccion() {
	        return leerEntero("Que quieres hacer: ");
	    }
	
	    public ProductoOtaku pedirDatos() {
	        String nombre = pedirNombre();
	        String categoria = pedirCategoria();
	        double precio = pedirPrecio();
	        int stock = pedirStock();
	        return new ProductoOtaku(nombre, categoria, precio, stock);
	    }
	
	public int Menu() {
		System.out.println("-------Menú-------");
		System.out.println("1. Agregar Producto");
		System.out.println("2. Buscar Producto");
		System.out.println("3. Buscar Todos los Productos");
		System.out.println("4. Actualizar un Producto");
		System.out.println("5. Eliminar un Producto");
		System.out.println("6. Buscar Producto por Nombre");
		System.out.println("7. Asistente IA");
		System.out.println("8. Salir");
		int eleccion = eleccion();
		return eleccion;
		
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	public void mostrarProducto(ProductoOtaku producto) {
		System.out.printf("ID: %d | NOMBRE: %-25s | CATEGORIA: %-10s | PRECIO: %.2f € | STOCK: %d\n",
                producto.getId(),
                producto.getNombre(),
                producto.getCategoria(),
                producto.getPrecio(),
                producto.getStock());
	}
	public void mostrarProductos(List<ProductoOtaku> lista) {
		    System.out.printf("%-5s | %-25s | %-10s | %-10s | %-5s\n", 
		                      "ID", "NOMBRE", "CATEGORIA", "PRECIO", "STOCK");
		    System.out.println("----------------------------------------------------------------------");

		    for (ProductoOtaku producto : lista) {
		        System.out.printf("%-5d | %-25s | %-10s | %10.2f € | %-5d\n",
		                          producto.getId(),
		                          producto.getNombre(),
		                          producto.getCategoria(),
		                          producto.getPrecio(),
		                          producto.getStock());
		    }
		}
	
	public int menuIA() {
		System.out.println("------- Menú IA -------");
		System.out.println("1. Generar Descripción de Producto");
		System.out.println("2. Sugerir Categoría para Producto con IA");
		System.out.println("3. Salir");
		int eleccion = eleccion();
		return eleccion;
		
	}

	}


