package Model;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import com.google.gson.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
public class LlmService {
    // Guardo la clave API y la URL del endpoint de OpenRouter
    private final String apiKey;
    private final String apiUrl;

    public LlmService() {
        // Al crear el servicio, intento cargar la clave API desde un archivo binario
        this.apiKey = cargarApiKeyDesdeArchivo(); // También podría usar System.getenv("OPENROUTER_API_KEY")

        // Esta es la URL base del endpoint de OpenRouter para enviar prompts al LLM
        this.apiUrl = "https://openrouter.ai/api/v1/chat/completions";

        // Si la clave API no está disponible, lo notifico
        if (this.apiKey == null || this.apiKey.isEmpty()) {
            System.err.println("ERROR: La API key no se pudo cargar.");
        }
    }

    // Este método intenta leer la API Key desde un archivo binario llamado "apikey.dat"
    private String cargarApiKeyDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("apikey.dat"))) {
            return (String) in.readObject(); // Devuelvo la clave si se puede leer correctamente
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error leyendo la API key: " + e.getMessage());
            return null; // Si hay error, devuelvo null
        }
    }

    // Este método envía un mensaje al LLM y devuelve su respuesta
    public String realizarSolicitud(String mensajeUsuario) {
        try {
            // Construyo el cuerpo de la petición en formato JSON
            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", "mistralai/mistral-small-3.1-24b-instruct:free"); // Modelo que quiero usar
            requestBody.addProperty("system", "Habla en español"); // Instrucción general al modelo
            requestBody.addProperty("temperature", 0.1); // Control de creatividad
            requestBody.addProperty("max_tokens", 1500); // Límite de longitud de la respuesta
            requestBody.addProperty("stream", false); // No uso streaming

            // Defino el mensaje del usuario como parte del array "messages"
            JsonArray messages = new JsonArray();
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user"); // Rol de quien envía el mensaje
            userMessage.addProperty("content", mensajeUsuario); // El mensaje que quiero enviar al LLM
            messages.add(userMessage);
            requestBody.add("messages", messages);

            // Creo un cliente HTTP moderno con la clase HttpClient
            HttpClient cliente = HttpClient.newHttpClient();

            // Construyo la solicitud HTTP POST con cabeceras y cuerpo
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl)) // La URL a la que hago la solicitud
                    .header("Authorization", "Bearer " + apiKey) // Autenticación con API Key
                    .header("Content-Type", "application/json") // Indico que envío JSON
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString(), StandardCharsets.UTF_8)) // Cuerpo de la petición
                    .build();

            // Envío la solicitud y obtengo la respuesta
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            // Convierto el cuerpo de la respuesta en un objeto JSON
            JsonObject respuestaJson = JsonParser.parseString(response.body()).getAsJsonObject();

            // Verifico que haya un array "choices" (la respuesta del modelo)
            if (!respuestaJson.has("choices")) {
                return "La respuesta no contiene 'choices'.\nRespuesta completa:\n" + respuestaJson.toString();
            }

            // Extraigo y devuelvo el contenido generado por el modelo
            return respuestaJson
                    .getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content").getAsString();

        } catch (IOException | InterruptedException | JsonParseException e) {
            // Capturo errores posibles (conexión, parseo, interrupciones)
            return "Error en la solicitud: " + e.getMessage();
        }
    }
}

