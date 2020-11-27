package app.rainworms.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Spel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 1000)
    private Speelsteen[] stapelStenenSpel;
    @Column(length = 1000)
    private ArrayList<Speler> spelers;
    
    public Spel() {
	}

	public Spel(Long id, Speelsteen[] stapelStenenSpel, ArrayList<Speler> spelers) {
		super();
		this.id = id;
		this.stapelStenenSpel = stapelStenenSpel;
		this.spelers = spelers;
	}

    
    public Long getId() {
        return id;
    }

	
	public Speelsteen[] getStapelStenenSpel() {
		return stapelStenenSpel;
	}

	
//	public void setStapelStenenSpel(Speelsteen[] stapelStenenSpel) {
//		this.stapelStenenSpel = stapelStenenSpel;
//	}
	
	public void setStapelStenenSpel() {
		
		Speelsteen[] speelstenen = new Speelsteen[16];
		
		int waarde = 21;
		int aantalWormen = 0;
		long id = 0;
	
		for (int i = 0; i<speelstenen.length; i++) {
			
			if (waarde <= 24) {
				aantalWormen = 1;
			} if (waarde >24 && waarde <= 28) {
				aantalWormen = 2;
			} if (waarde >28 && waarde <= 32) {
				aantalWormen = 3;
			} if (waarde > 32) {
				aantalWormen = 4;
			}
			
			speelstenen[i] = new Speelsteen(id, waarde, aantalWormen, false);
			
			waarde++;
			id++;
		}
		
		this.stapelStenenSpel = speelstenen;
			
	}


	public ArrayList<Speler> getSpelers() {
		return spelers;
	}

	
	public void setSpelers(ArrayList<Speler> spelers) {
		this.spelers = spelers;
	}
	
	public void addSpeler(Speler speler) {
		spelers.add(speler);
	}

	

	
}
