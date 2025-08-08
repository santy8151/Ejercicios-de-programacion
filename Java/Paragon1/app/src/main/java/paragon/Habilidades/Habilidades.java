package paragon.Habilidades;

public class Habilidades {
    private String nombre;
    private int costo;
    private int daño;

    public Habilidades(String nombre, int costo, int daño) {
        this.nombre = nombre;
        this.costo = costo;
        this.daño = daño;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosto() {
        return costo;
    }

    public int getDaño() {
        return daño;
    }

    @Override
    public String toString() {
        return nombre + " (Costo MP: " + costo + ", Daño: " + daño + ")";
    }
}

