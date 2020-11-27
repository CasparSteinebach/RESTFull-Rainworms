package app.rainworms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Speler implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7661198116179048153L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int punten;
    private String naam;
    @Column (length = 1000)
    private Dobbelsteen[] dobbelstenen;
    @Column (length = 1000)
	private ArrayList <Speelsteen> stapelSpeler;
    

//    @OneToMany
//    @JsonManagedReference
//    private List<UrenFormulier> urenFormulier = new ArrayList<>();

    public Speler() {
    }
    
	public Long getId() {
		return id;
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

	
	public ArrayList<Speelsteen> getStapelSpeler() {
		return stapelSpeler;
	}

	
	public void setStapelSpeler(ArrayList<Speelsteen> stapelSpeler) {
		this.stapelSpeler = stapelSpeler;
	}
    
	public Dobbelsteen[] getDobbelstenen() {
		return dobbelstenen;
	}

	public void setDobbelstenen(Dobbelsteen[] dobbelstenen) {
		this.dobbelstenen = dobbelstenen;
	}
    

//    public void addUrenFormulierToArray(UrenFormulier uf) {
//        urenFormulier.add(uf);
//        uf.setGebruiker(this);
//    }

}
