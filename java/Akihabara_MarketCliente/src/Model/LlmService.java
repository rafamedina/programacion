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
        // Cuando creo una instancia de esta clase, intento leer la API Key desde un archivo binario
        this.apiKey = cargarApiKeyDesdeArchivo(); // También podría usar una variable de entorno

        // Establezco la URL del servicio de OpenRouter (donde se hacen las solicitudes)
        this.apiUrl = "https://openrouter.ai/api/v1/chat/completions";

        // Si no pude cargar la clave, muestro un error en consola
        if (this.apiKey == null || this.apiKey.isEmpty()) {
            System.err.println("ERROR: La API key no se pudo cargar.");
        }
    }

    // Este método busca la API Key dentro de un archivo local llamado "apikey.dat"
    private String cargarApiKeyDesdeArchivo() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("apikey.dat"))) {
            // Si todo sale bien, devuelvo la cadena que representa la API key
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si no se pudo leer, imprimo el error y retorno null
            System.err.println("Error leyendo la API key: " + e.getMessage());
            return null;
        }
    }

    // Este método se encarga de enviar un mensaje al modelo LLM y recibir su respuesta
    public String realizarSolicitud(String mensajeUsuario) {
        try {
            // Armo el cuerpo JSON de la solicitud HTTP con los parámetros del modelo
            JsonObject requestBody = new JsonObject();
            requestBody.addProperty("model", "mistralai/mistral-small-3.1-24b-instruct:free"); // Modelo específico
            requestBody.addProperty("system", "Habla en español"); // Instrucción general para el comportamiento del modelo
            requestBody.addProperty("temperature", 0.1); // Bajo nivel de creatividad (más precisión)
            requestBody.addProperty("max_tokens", 1500); // Máximo de tokens para la respuesta
            requestBody.addProperty("stream", false); // No usamos respuestas en streaming

            // Agrego el mensaje del usuario como parte del array de mensajes
            JsonArray messages = new JsonArray();
            JsonObject userMessage = new JsonObject();
            userMessage.addProperty("role", "user");
            userMessage.addProperty("content", mensajeUsuario);
            messages.add(userMessage);
            requestBody.add("messages", messages);

            // Configuro el cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();

            // Creo la solicitud HTTP con método POST y cabeceras necesarias
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString(), StandardCharsets.UTF_8))
                    .build();

            // Envío la solicitud al servidor de OpenRouter y obtengo la respuesta como string
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            // Convierto la respuesta en un objeto JSON para poder analizarla
            JsonObject respuestaJson = JsonParser.parseString(response.body()).getAsJsonObject();

            // Reviso que haya un array llamado "choices", que contiene la respuesta del modelo
            if (!respuestaJson.has("choices")) {
                return "La respuesta no contiene 'choices'.\nRespuesta completa:\n" + respuestaJson.toString();
            }

            // Devuelvo el contenido textual que el modelo generó (la respuesta del chatbot)
            return respuestaJson
                    .getAsJsonArray("choices")
                    .get(0).getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content").getAsString();

        } catch (IOException | InterruptedException | JsonParseException e) {
            // En caso de error (red, parseo, interrupción), devuelvo un mensaje de error
            return "Error en la solicitud: " + e.getMessage();
        }
    }
}


