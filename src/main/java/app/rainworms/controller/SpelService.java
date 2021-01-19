package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Speelsteen;
import app.rainworms.model.Spel;
import app.rainworms.model.Speler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class SpelService {
   @Autowired
   SpelRepository spelrepository;
   
   @Autowired
   SpelerRepository spelerrepository;
   
   public Spel setStapelStenen(long id) {  
	   	Spel spel = spelrepository.findById(id).get();
		spel.setStapelStenenSpel();
		return spel;
	}

   public Spel addSpel(Spel spel) {
	   System.out.println("Spel gemaakt");
	   Speelsteen[] speelstenen = new Speelsteen[16];
	   ArrayList<Speler> spelers = new ArrayList<>();
	   System.out.println(Arrays.toString(speelstenen));
	   spel.setStapelStenenSpel();
	   spel.setSpelers(spelers);
	   return spelrepository.save(spel);
	}

public Spel addSpelerToSpel(Long id, Long spelerid) {
	Spel spel = spelrepository.findById(id).get();
	Speler speler = spelerrepository.findById(spelerid).get();
	spel.addSpeler(speler);
	return spel;
}

public Spel getSpelById(long id) {
	Spel spel = spelrepository.findById(id).get();
	return spel;
}
   
   
   
}
   
