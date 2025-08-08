package paragon;

import paragon.Personajes.Personaje;

public interface Acciones {

    void atacar(Personaje objetivo);
    void usarHabilidad(Personaje objetivo);
    void recibirDaño(int cantidad);
    int poderTotal();

}
