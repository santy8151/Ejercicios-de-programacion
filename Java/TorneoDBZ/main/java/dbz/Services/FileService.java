package dbz.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import dbz.Config;
import dbz.Model.Personaje;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class FileService {
    private static final Logger logger = Logger.getLogger(FileService.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void guardarPersonajes(List<Personaje> personajes) {
        try {
            if (personajes == null) return;
            File f = new File(Config.FILE_PATH);
            mapper.writerWithDefaultPrettyPrinter().writeValue(f, personajes);
            logger.info("Guardado en: " + f.getAbsolutePath());
        } catch (Exception e) {
            logger.severe("Error guardando personajes: " + e.getMessage());
        }
    }

    public static List<Personaje> cargarPersonajes() {
        try {
            File f = new File(Config.FILE_PATH);
            if (!f.exists()) return Collections.emptyList();
            return mapper.readValue(f, new TypeReference<List<Personaje>>(){});
        } catch (Exception e) {
            logger.severe("Error cargando personajes: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
