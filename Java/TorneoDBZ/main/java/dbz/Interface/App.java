package dbz.Interface;

import dbz.Config;
import dbz.Model.*;
import dbz.Services.APIService;
import dbz.Services.FileService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        Logger root = Logger.getLogger(""); root.setLevel(Level.INFO);
        logger.info("=== Torneo de Dragon Ball ===");

        List<Personaje> lista = FileService.cargarPersonajes();
        if (lista == null || lista.isEmpty()) {
            logger.info("No hay datos locales. Llamando API...");
            lista = APIService.obtenerPersonajes();
            if (lista != null && !lista.isEmpty()) {
                FileService.guardarPersonajes(lista);
            } else {
                logger.severe("No se obtuvieron personajes. Terminando."); return;
            }
        } else {
            logger.info("Cargando personajes desde archivo local. Total: " + lista.size());
        }

        // Parte A - Fila: enfrentamientos por orden de llegada (VS)
        FilaTorneo<Personaje> fila = new FilaTorneo<>();
        for (Personaje p : lista) fila.agregar(p);
        System.out.println("\n=== PARTE A: ENFRENTAMIENTOS (Orden de llegada) ===");
        while (!fila.estaVacia()) {
            Personaje a = fila.siguiente();
            if (!fila.estaVacia()) {
                Personaje b = fila.siguiente();
                System.out.println(a.getName() + " VS " + b.getName());
            } else {
                System.out.println(a.getName() + " pasa sin pelear."); 
            }
        }

        // Parte B - Pila de poder
        System.out.println("\n=== PARTE B: RASTREADOR DE PODER (Ki > " + Config.DEFAULT_KI_THRESHOLD + ") ===");
        PilaPoder<Personaje> pila = PilaPoder.fromPersonajesByKi(lista, Config.DEFAULT_KI_THRESHOLD);
        while (!pila.vacia()) {
            Personaje p = pila.pop();
            System.out.println(p.getName() + " - Ki: " + p.getKi());
        }

        // Parte C - Bolsa de razas
        BolsaRazas bolsa = new BolsaRazas();
        for (Personaje p : lista) bolsa.add(p.getRace());
        System.out.println("\n=== PARTE C: CENSO DE RAZAS ===");
        System.out.println("Total de razas en bolsa: " + bolsa.size());
        System.out.println(bolsa.getAll());
    }
}
