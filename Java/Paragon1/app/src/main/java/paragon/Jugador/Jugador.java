package PARAGON;

import java.util.ArrayList;
import java.util.List;
import paragon.Personajes.Personaje;

public class Jugador {
    private String usuario;
    private String contraseña;
    private List<Personaje> personajes;

    public Jugador(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.personajes = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public String getUsuario() {
        return usuario;
    }
}
