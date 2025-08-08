package dbz.Model;

import java.util.LinkedList;
import java.util.Queue;

public class FilaTorneo<T> {
    private final Queue<T> fila;

    public FilaTorneo() { this.fila = new LinkedList<>(); }

    public void agregar(T elemento) { fila.add(elemento); }

    public T siguiente() { return fila.poll(); }

    public boolean estaVacia() { return fila.isEmpty(); }

    public int size() { return fila.size(); }
}
