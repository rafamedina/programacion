
Guía del Desarrollador/Usuario
1. Cómo configurar la base de datos MySQL (si se hace sin el ejecutable)

 Pasos para configurar la base de datos MySQL:

 1. Crear la base de datos:
    Abre tu cliente MySQL y ejecuta el siguiente comando para crear la base de datos para la aplicación:


 2. Configurar las tablas:
    Una vez creada la base de datos, debes importar las tablas necesarias. Asegúrate de tener el archivo .sql con las tablas requeridas o crea las tablas manualmente utilizando el siguiente esquema de ejemplo:



 3. Modificar los parámetros de conexión:
    En el archivo `DatabaseConnection.java`, actualiza los parámetros de conexión con tus credenciales:
    	String url = "jdbc:mysql://localhost:3306/akihabara_db"; // Dirección y nombre de la base de datos
    	String usuario = "root"; // Usuario de la base de datos
    	String contraseña = "1234"; // Contraseña del usuario


2. Cómo configurar la API Key de OpenRouter

 Para interactuar con la API de OpenRouter, necesitas configurar tu API Key:

 1. Obtener tu API Key:
    Regístrate en OpenRouter ( https://openrouter.ai ) y obtén tu clave API desde el panel de configuración.

 2. Configuración de la clave API:
    Coloca la clave API en un archivo llamado `apiKey.dat`. Este archivo debe estar ubicado en el directorio raíz de tu proyecto (en el mismo nivel que los archivos de clase).

 3. Leer y deserializar la clave API en tu código:
    La clave API debe estar serializada en el archivo `apiKey.dat`. El código de la aplicación deserializa este archivo para obtener la clave.

    **Ejemplo de código para leer la clave API:**




	private String cargarApiKeyDesdeArchivo() {
    	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("apikey.dat"))) {
        	// Si todo sale bien, devuelvo la cadena que representa la API key
        	return (String) in.readObject();
    	} catch (IOException | ClassNotFoundException e) {
        	// Si no se pudo leer, imprimo el error y retorno null
        	System.err.println("Error leyendo la API key: " + e.getMessage());
        	return null;
    	}
	

    El archivo `apiKey.dat` debe contener la clave de la API serializada como una cadena de texto.

 4. Crear el archivo `apiKey.dat`:
    Crea un archivo llamado `apiKey.dat` en la raíz del proyecto. Este archivo debe contener solo la clave de la API serializada.

  
3. Cómo compilar y ejecutar la aplicación

 Pasos para compilar y ejecutar la aplicación:

 1. Pre-requisitos:
    - Asegúrate de tener instalado **JDK 11** o superior.
    - Asegúrate de tener configurada la base de datos MySQL como se explicó arriba.
    - También necesitarás el archivo `apiKey.dat` configurado correctamente.

 2. Compilación del proyecto:
    Si estás utilizando  Eclipse, simplemente importa el proyecto como un proyecto Java y la IDE se encargará de compilarlo automáticamente.

    Si prefieres compilar manualmente desde la línea de comandos, ve a la carpeta del proyecto y usa los siguientes comandos:

    javac -d bin src/*.java

    Esto compilará todos los archivos Java y generará los `.class` en la carpeta `bin`.

 3. Ejecución de la aplicación:
    Para ejecutar el proyecto, usa el siguiente comando en la terminal o ejecútalo desde tu IDE (en Eclipse,  simplemente haz clic en "Run" para `Main.java`):


    java -cp bin Main


    Esto ejecutará la clase `Main`, que arranca la ventana principal de la aplicación y el menú de opciones.




4. Breve resumen de las funcionalidades y la estructura de clases

 Funcionalidades de la aplicación:

 - Gestión de productos: El sistema permite gestionar los productos del mercado Akihabara.
La gestión de productos se desglosa en:

   - Agregar productos: Insertar nuevos productos en la base de datos.
   - Buscar productos por ID: Consultar los detalles de un producto dado su ID.
   - Listar todos los productos: Mostrar todos los productos almacenados.
   - Actualizar productos: Modificar detalles de un producto ya existente.
   - Eliminar productos: Eliminar un producto de la base de datos dado su ID.
   - Buscar productos por nombre: Buscar productos que contengan un nombre específico.

 - Gestión de clientes: El sistema permite gestionar los clientes del mercado Akihabara.
La gestión de clientes se desglosa en:

   - Agregar clientes: Insertar nuevos clientes en la base de datos.
   - Buscar clientes por ID: Consultar los detalles de un clientes dado su ID.
   - Listar todos los clientes: Mostrar todos los clientes almacenados.
   - Actualizar clientes: Modificar detalles de un cliente ya existente.
   - Eliminar clientes: Eliminar un cliente de la base de datos dado su ID.
   - Buscar clientes por correo: Buscar clientes que contengan un correo específico.


 - Asistente IA: Integración con OpenRouter:
Que a su vez se desglosa en:

  -Generación de descripciones de productos: Solicita a la IA una descripción atractiva para un producto específico.
  - Sugerir categoría de producto: La IA sugiere una categoría apropiada para un producto según su nombre.

Estructura de clases:

Main.java : Punto de entrada de la aplicación; inicia el controlador e inicializa la conexión a la base de datos.
ProductoController.java : Controlador principal que gestiona la lógica de negocio y la interacción entre vistas, modelo y DAO de productos.
ClienteController.java : Controlador encargado de la lógica de negocio relacionada con los clientes.
ProductoDAO.java : Interfaz que define métodos para manipular datos de productos en la base de datos.
ClienteDAO.java : Interfaz que define métodos para manipular datos de clientes en la base de datos.
ProductoOtaku.java : Clase modelo que representa un producto con atributos como id, nombre, categoría, precio y stock.
ClienteOtaku.java : Clase modelo que representa a un cliente con atributos como id, nombre, email, telefono, fecha de registro.
InterfazConsola.java : Vista encargada de interactuar con el usuario a través de la consola (lectura y muestra de datos).
LlmService.java : Servicio que conecta con la API de OpenRouter para generar descripciones y sugerencias de categoría.



Utilizar el Ejecutable:
para utilizar el ejecutable asegúrate de tener tu archivo apiKey.dat en la misma carpeta que el .jar