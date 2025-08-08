package paragon.Personajes;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import paragon.Acciones;
import paragon.Habilidades.Habilidades;
import paragon.Items.Item;


public abstract class Personaje implements Acciones {

    protected UUID id;
    protected String nombre;
    protected int hp;
    protected int mp;
    protected int nivel = 1;
    protected int fuerza;
    protected int inteligencia;
    protected int destreza;
    protected List<Item> items = new ArrayList<>();
    protected List<Habilidades> habilidades = new ArrayList<>();

    protected static final Logger logger = LogManager.getLogger(Personaje.class);

    public Personaje(String nombre, int hp, int mp, int fuerza, int inteligencia, int destreza) throws Exception {
        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }
            this.nombre = nombre;
            this.id = UUID.randomUUID();
            this.hp = hp;
            this.mp = mp;
            this.fuerza = fuerza;
            this.inteligencia = inteligencia;
            this.destreza = destreza;
            logger.info("Personaje creado: " + this.nombre);
        } catch (Exception e) {
            logger.error("Error creando personaje: " + e.getMessage());
            throw new Exception("Error en constructor de personaje", e);
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getNivel() {
        return nivel;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void recibirDaño(int cantidad) {
        this.hp -= cantidad;
        logger.info(this.nombre + " recibió " + cantidad + " de daño. HP restante: " + this.hp);
    }

    public void agregarItem(Item item) {
        try {
            this.items.add(item);
            logger.info("Item agregado a " + nombre + ": " + item.getNombre());
        } catch (Exception e) {
            logger.error("Error al agregar item: " + e.getMessage());
        }
    }

    public void agregarHabilidad(Habilidades habilidad) {
        try {
            this.habilidades.add(habilidad);
            logger.info("Habilidad agregada a " + nombre + ": " + habilidad.getNombre());
        } catch (Exception e) {
            logger.error("Error al agregar habilidad: " + e.getMessage());
        }
    }

    public abstract int poderTotal();
}
