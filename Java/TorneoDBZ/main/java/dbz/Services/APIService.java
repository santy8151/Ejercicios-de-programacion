package dbz.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import dbz.Config;
import dbz.Model.Personaje;

import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class APIService {
    private static final Logger logger = Logger.getLogger(APIService.class.getName());
    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Personaje> obtenerPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        try {
            HttpRequest req = HttpRequest.newBuilder()
                    .uri(URI.create(Config.API_URL))
                    .GET()
                    .header("Accept", "application/json")
                    .build();
            HttpResponse<String> resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            if (resp.statusCode() != 200) {
                logger.warning("API returned status: " + resp.statusCode());
                return personajes;
            }
            String body = resp.body();
            JsonNode root = mapper.readTree(body);
            JsonNode items = root.has("items") ? root.get("items") : root;
            if (items.isArray()) {
                for (JsonNode item : items) {
                    Personaje p = mapper.treeToValue(item, Personaje.class);
                    personajes.add(p);
                }
            }
            logger.info("Personajes obtenidos: " + personajes.size());
        } catch (Exception e) {
            logger.severe("Error consumiendo API: " + e.getMessage());
        }
        return personajes;
    }
}
