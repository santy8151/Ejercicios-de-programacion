package dbz.Model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Personaje implements Serializable {
    private String id;
    private String name;
    private String race;
    private String gender;
    private String ki;
    private String maxKi;
    private String description;
    private String image;
    private String affiliation;

    public Personaje() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRace() { return race; }
    public void setRace(String race) { this.race = race; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getKi() { return ki; }
    public void setKi(String ki) { this.ki = ki; }

    public String getMaxKi() { return maxKi; }
    public void setMaxKi(String maxKi) { this.maxKi = maxKi; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getAffiliation() { return affiliation; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }

    @Override
    public String toString() {
        return (name == null ? "SinNombre" : name) + " (" + (race==null?"Desconocida":race) + ") - Ki: " + (ki==null?"0":ki);
    }
}
