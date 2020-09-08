package app.rainworms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
public class Speler extends Spel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private int punten;
    private String naam;

//    @OneToMany
//    @JsonManagedReference
//    private List<UrenFormulier> urenFormulier = new ArrayList<>();

    public Speler() {
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

//    public void addUrenFormulierToArray(UrenFormulier uf) {
//        urenFormulier.add(uf);
//        uf.setGebruiker(this);
//    }

}
