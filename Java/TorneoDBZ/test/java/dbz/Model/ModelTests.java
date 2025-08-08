package dbz.Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ModelTests {

    @Test
    void testFilaTorneo() {
        FilaTorneo<String> fila = new FilaTorneo<>();
        assertTrue(fila.estaVacia());
        fila.agregar("A"); fila.agregar("B"); assertEquals(2, fila.size());
        assertEquals("A", fila.siguiente()); assertEquals("B", fila.siguiente());
    }

    @Test
    void testPilaPoder() {
        PilaPoder<String> p = new PilaPoder<>(); assertTrue(p.vacia());
        p.push("X"); p.push("Y"); assertEquals("Y", p.pop()); assertEquals("X", p.pop());
    }

    @Test
    void testBolsaRazas() {
        BolsaRazas b = new BolsaRazas(); b.add("Saiyan"); b.add("Human"); assertEquals(2, b.size());
    }

    @Test
    void testFromPersonajesByKi() {
        Personaje a = new Personaje(); a.setName("Goku"); a.setKi("1200000");
        Personaje c = new Personaje(); c.setName("Krillin"); c.setKi("900");
        Personaje v = new Personaje(); v.setName("Vegeta"); v.setKi("2000000");
        List<Personaje> list = List.of(a, c, v);
        PilaPoder<Personaje> pila = PilaPoder.fromPersonajesByKi(list, 1000000L);
        assertEquals(2, pila.size()); assertEquals("Vegeta", pila.pop().getName()); assertEquals("Goku", pila.pop().getName());
    }
}
