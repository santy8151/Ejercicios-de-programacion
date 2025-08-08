package paragon.Jugador;

import paragon.Habilidades.Habilidades;
import paragon.Personajes.Personaje;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mago extends Personaje {
    private static final Logger logger = LogManager.getLogger(Mago.class);

    public Mago(String nombre, int hp, int mp, int fuerza, int inteligencia, int destreza) throws Exception {
        super(nombre, hp, mp, fuerza, inteligencia, destreza);
        logger.info("Mago creado: " + this.nombre);
    }

    @Override
    public void atacar(Personaje objetivo) {
        int daño = 10 + fuerza;
        objetivo.recibirDaño(daño);
        logger.info(nombre + " atacó físicamente causando " + daño + " de daño.");
    }

    @Override
    public void usarHabilidad(Personaje objetivo) {
        if (habilidades.isEmpty()) {
            logger.warn(nombre + " no tiene habilidades para usar.");
            return;
        }

        Habilidades habilidad = habilidades.get(0);
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
        int poder = (inteligencia * nivel) + mp;
        logger.info("Poder total de " + nombre + ": " + poder);
        return poder;
    }
}

