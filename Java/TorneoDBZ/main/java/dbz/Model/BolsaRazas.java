package dbz.Model;

import java.util.ArrayList;
import java.util.List;

public class BolsaRazas {
    private final List<String> razas = new ArrayList<>();

    public void add(String raza) { razas.add(raza == null ? "Desconocida" : raza); }

    public int size() { return razas.size(); }

    public List<String> getAll() { return new ArrayList<>(razas); }
}
