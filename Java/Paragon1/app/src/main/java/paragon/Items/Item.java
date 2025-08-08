package paragon.Items;

public class Item {
    private String nombre;
    private String efecto; // Ej: "Curación", "Protección", "Aumento de daño"

    public Item(String nombre, String efecto) {
        this.nombre = nombre;
        this.efecto = efecto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    @Override
    public String toString() {
        return nombre + " (" + efecto + ")";
    }
}

