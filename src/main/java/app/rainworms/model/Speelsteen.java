package app.rainworms.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Speelsteen implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -93655340851460245L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int waarde;
    private int aantalWormen;
    private boolean bovenopStapel;
//    @ManyToOne
//    @JoinColumn(name="id", nullable=false)
//    private Spel spel;

    public Speelsteen(){}
    
    

   public Speelsteen(long id, int waarde, int aantalWormen, boolean bovenopStapel) {
	super();
	this.id = id;
	this.waarde = waarde;
	this.aantalWormen = aantalWormen;
	this.bovenopStapel = bovenopStapel;
}



//    public Speelsteen(Spel spel){
//        this.spel = spel;
//    }

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * @return the bovenopStapel
	 */
	public boolean isBovenopStapel() {
		return bovenopStapel;
	}

	/**
	 * @param bovenopStapel the bovenopStapel to set
	 */
	public void setBovenopStapel(boolean bovenopStapel) {
		this.bovenopStapel = bovenopStapel;
	}

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
