import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clientes {
    int idCliente;
	String nombre;
    String email;
    int telefono;
    // Constructor
    public Clientes(String nombre, String email, int telefono) {
        try {
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para buscar si el cliente ya existe
    public boolean buscarCliente( String email) {
        Connection conexion = null;
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            conexion = Conexion.conectar();  // Conectar a la base de datos
            if (conexion != null) {
                String select = "SELECT * FROM Clientes WHERE email=?";
                psSelect = conexion.prepareStatement(select);
                psSelect.setString(1, email);  // Establecer el parámetro de la consulta

                rs = psSelect.executeQuery();  // Ejecutar la consulta

                if (rs.next()) {
                    return true;  // Si el cliente existe, devolver true
                } else {
                    return false;  // Si no existe, devolver false
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL BUSCAR CLIENTE: " + e.getMessage());
        } 
        return false;
    }


    // Método para insertar un nuevo cliente
    public boolean insertarClientes(String nombre, String email, int telefono) {
        Connection conexion = null;
        PreparedStatement psInsert = null;

        try {
            conexion = Conexion.conectar();  // Conectar a la base de datos
            if (conexion != null) {
                // Verificar si el cliente ya existe
                if (buscarCliente(email)) {
                    System.out.println("El cliente ya existe, no se puede insertar.");
                    return false;
                }

                // Si no existe, proceder con la inserción
                String insert = "INSERT INTO Clientes (nombre, email, telefono) VALUES (?, ?, ?)";
                psInsert = conexion.prepareStatement(insert);
                psInsert.setString(1, nombre);
                psInsert.setString(2, email);
                psInsert.setInt(3, telefono);

                psInsert.executeUpdate();
                System.out.println("CLIENTE AÑADIDO CORRECTAMENTE.");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL AÑADIR CLIENTE: " + e.getMessage());
        } 
        return false;
    }
    
    public void mostrarClientes() {
        Connection conexion = null;
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            conexion = Conexion.conectar();  // Conectar a la base de datos
            if (conexion != null) {
                String select = "SELECT * FROM Clientes";  // Consulta SQL

                // Preparar y ejecutar la consulta
                psSelect = conexion.prepareStatement(select);
                rs = psSelect.executeQuery();

                // Imprimir cabecera
                System.out.printf("%-10s %-25s %-20s %-10s\n", "ID", "NOMBRE", "EMAIL", "TELEFONO");
                System.out.println("----------------------------------------------------------------------------");

                // Recorrer los resultados y mostrarlos
                while (rs.next()) {
                    System.out.printf("%-10s %-25s %-20s %-10d\n",
                            rs.getString("id_cliente"),
                            rs.getString("nombre"),
                            rs.getString("email"),
                            rs.getInt("telefono"));
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL MOSTRAR CLIENTES: " + e.getMessage());
        } 
    }
 
    
    public boolean eliminarClientes(String email) {
        Connection conexion = null;
        PreparedStatement psDelete = null;

        try {
            conexion = Conexion.conectar();  // Conectar a la base de datos
            if (conexion != null) {
                // Verificar si el cliente existe por email
                if (buscarCliente(email)) {  
                    String delete = "DELETE FROM Clientes WHERE email = ?";
                    psDelete = conexion.prepareStatement(delete);
                    psDelete.setString(1, email);

                    psDelete.executeUpdate();  // Ejecutar la eliminación
                    System.out.println("CLIENTE ELIMINADO CORRECTAMENTE.");
                    return true;
                } else {
                    System.out.println("EL CLIENTE NO EXISTE.");
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL ELIMINAR CLIENTE: " + e.getMessage());
        } 
        return false;
    }

    
    public boolean editarClientes(String nombre,int telefono, String email ) {
    	Connection conexion = null;
        PreparedStatement psInsert = null;

        try {
            conexion = Conexion.conectar();  // Conectar a la base de datos
            if (conexion != null) {
                // Verificar si el cliente ya existe
                if (buscarCliente(email)) {
                	String update = "UPDATE Clientes SET nombre = ?, telefono = ? WHERE email = ?";
                	PreparedStatement psUpdate = conexion.prepareStatement(update);
                	psUpdate.setString(1, nombre);
                	psUpdate.setInt(2, telefono);
                	psUpdate.setString(3, email);

                	psUpdate.executeUpdate();
                	System.out.println("CLIENTE ACTUALIZADO CORRECTAMENTE.");

                    return true;
                } else {                	
                	System.out.println("EL CLIENTE NO EXISTE");
                	return false;           	
                }
        
            }
        } catch (SQLException e) {
            System.out.println("ERROR AL AÑADIR CLIENTE: " + e.getMessage());
        } 
        return false;
    }
    
   }



























