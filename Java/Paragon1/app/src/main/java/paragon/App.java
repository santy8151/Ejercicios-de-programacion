package paragon;

import paragon.Habilidades.Habilidades;
import paragon.Items.Item;
import paragon.Jugador.Mago;
import paragon.Personajes.Guerrero;
import paragon.Personajes.Personaje;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        try {
            // Crear habilidades
            Habilidades bolaDeFuego = new Habilidades("Bola de Fuego", 20, 30);
            Habilidades espadaFlamígera = new Habilidades("Espada Flamígera", 15, 20);

            // Crear ítems
            Item pocionVida = new Item("Poción de Vida", "Curación");
            Item escudoDeHierro = new Item("Escudo de Hierro", "Protección");

            // Crear personajes
            Personaje guerrero = new Guerrero("Thor", 150, 40, 35, 10, 10);
            Personaje mago = new Mago("Merlín", 100, 80, 10, 35, 10);

            // Asignar habilidades e ítems
            guerrero.agregarHabilidad(espadaFlamígera);
            guerrero.agregarItem(escudoDeHierro);

            mago.agregarHabilidad(bolaDeFuego);
            mago.agregarItem(pocionVida);

            // Simular batalla
            logger.info(" ¡Comienza la batalla entre " + guerrero.getNombre() + " y " + mago.getNombre() + "!\n");

            for (int turno = 1; turno <= 3; turno++) {
                logger.info(" Turno " + turno);

                // Turno 1: Guerrero ataca
                logger.info(" " + guerrero.getNombre() + " ataca.");
                guerrero.atacar(mago);

                // Verificar si el mago sigue con vida
                if (mago.getHp() <= 0) {
                    logger.info(" " + mago.getNombre() + " ha sido derrotado.");
                    break;
                }

                // Turno 2: Mago usa habilidad
                logger.info(" " + mago.getNombre() + " usa habilidad.");
                mago.usarHabilidad(guerrero);

                if (guerrero.getHp() <= 0) {
                    logger.info(" " + guerrero.getNombre() + " ha sido derrotado.");
                    break;
                }
            }

            logger.info("\ Batalla terminada.");
            logger.info(guerrero.getNombre() + " HP: " + guerrero.getHp());
            logger.info(mago.getNombre() + " HP: " + mago.getHp());

        } catch (Exception e) {
            logger.error("Ocurrió un error en la batalla: " + e.getMessage());
        }
    }
}
