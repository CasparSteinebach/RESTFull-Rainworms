package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Spel;
import app.rainworms.model.Speler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;



@Service
@Transactional
public class SpelerService {
    @Autowired SpelerRepository spelerrepository;
    @Autowired DobbelSteenRepository dobbelsteenrepository;
    
    static double percent;
    
    public Speler addSpeler (Speler speler) {
        System.out.println("nieuwe speler toegevoegd");
        
        return spelerrepository.save(speler);
    }

	public Speler getSpelerById(long id) {
		return spelerrepository.findById(id).get();
	}
	
	public Speler chainDobbelstenenToSpeler (Long spelerid) {
		Speler speler = spelerrepository.findById(spelerid).get();
		Dobbelsteen[] dobbelstenen = new Dobbelsteen[8];
		
		for(int i = 0; i < dobbelstenen.length ; i++) {
		dobbelstenen[i] = new Dobbelsteen();
		dobbelstenen[i].setId(i);
		dobbelstenen[i].setWorp();
		}
		speler.setDobbelstenen(dobbelstenen);
		
		return speler;
		
	}
	
	public Dobbelsteen getDobbelsteenFromSpelerById(Long spelerid, Integer dobbelsteenid) {
		Speler speler = spelerrepository.findById(spelerid).get();
		
		for(Dobbelsteen dobbelsteen : speler.getDobbelstenen()) {
			if (dobbelsteen.getId().intValue() == dobbelsteenid) {
			System.out.println("Doet is het met id " + dobbelsteen.getId());
			}
		}
		return speler.getDobbelstenen()[dobbelsteenid];
	}
	
	

	
    
    
}
