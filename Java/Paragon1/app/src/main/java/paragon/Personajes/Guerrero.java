package paragon.Personajes;

import paragon.Habilidades.Habilidades;
import paragon.Personajes.Personaje;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Guerrero extends Personaje {

    private static final Logger logger = LogManager.getLogger(Guerrero.class);

    public Guerrero(String nombre, int hp, int mp, int fuerza, int inteligencia, int destreza) throws Exception {
        super(nombre, hp, mp, fuerza, inteligencia, destreza);
        logger.info("Guerrero creado: " + this.nombre);
    }

    @Override
    public void atacar(Personaje objetivo) {
        int daño = 10 + this.fuerza;
        logger.info(nombre + " ataca con fuerza causando " + daño + " de daño a " + objetivo.nombre);
        objetivo.recibirDaño(daño);
    }

    @Override
    public void usarHabilidad(Personaje objetivo) {
        if (habilidades.isEmpty()) {
            logger.warn(nombre + " no tiene habilidades para usar.");
            return;
        }

        Habilidades habilidad = habilidades.get(0); // Simple
        if (mp >= habilidad.getCosto()) {
            mp -= habilidad.getCosto();
            int daño = habilidad.getDaño() + inteligencia;
            objetivo.recibirDaño(daño);
            logger.info(nombre + " usó habilidad " + habilidad.getNombre() + " causando " + daño + " de daño.");
        } else {
            logger.warn(nombre + " no tiene suficiente MP para usar " + habilidad.getNombre());
        }
    }

    @Override
    public int poderTotal() {
        int poder = (fuerza * nivel) + hp;
        logger.info("Poder total de " + nombre + ": " + poder);
        return poder;
    }
}
