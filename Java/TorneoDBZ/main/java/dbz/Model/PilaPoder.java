package dbz.Model;

import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PilaPoder<T> {
    private static final Logger logger = Logger.getLogger(PilaPoder.class.getName());
    private final Stack<T> pila = new Stack<>();

    public void push(T elemento) { pila.push(elemento); }

    public T pop() { return pila.pop(); }

    public boolean vacia() { return pila.isEmpty(); }

    public int size() { return pila.size(); }

    public static PilaPoder<Personaje> fromPersonajesByKi(List<Personaje> personajes, long threshold) {
        PilaPoder<Personaje> p = new PilaPoder<>();
        if (personajes == null) return p;
        for (Personaje per : personajes) {
            long k = parseKi(per.getKi());
            if (k > threshold) p.push(per);
        }
        logger.info("Pila creada con tamaño=" + p.size());
        return p;
    }

    private static long parseKi(String ki) {
        if (ki == null) return 0L;
        try {
            String digits = ki.replaceAll("[^0-9]", "");
            if (digits.isEmpty()) return 0L;
            return Long.parseLong(digits);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
