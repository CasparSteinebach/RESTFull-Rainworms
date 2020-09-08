package app.rainworms.model;

import javax.persistence.*;

@Entity
public class Speelsteen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private int waarde;
    private int aantalWormen;
//    @ManyToOne
//    @JoinColumn(name="id", nullable=false)
//    private Spel spel;

    public Speelsteen(){}

//    public Speelsteen(Spel spel){
//        this.spel = spel;
//    }

    public Speelsteen(int waarde, int wormen){
        this.waarde = waarde;
        this.aantalWormen = wormen;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public int getAantalWormen() {
        return aantalWormen;
    }

    public void setAantalWormen(int aantalWormen) {
        this.aantalWormen = aantalWormen;
    }

//    public Spel getSpel() {
//        return spel;
//    }
//
//    public void setSpel(Spel spel) {
//        this.spel = spel;
//    }
}
