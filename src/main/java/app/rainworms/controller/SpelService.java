package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Speelsteen;
import app.rainworms.model.Spel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Set;

@Service
@Transactional
public class SpelService {
   @Autowired
   SpelRepository spelrepository;
   
   public Spel setStapelStenen(long id) {
	   
	   	Spel spel = spelrepository.findById(id).get();
	   	
//	   	System.out.println(Arrays.toString(spel.getStapelStenenSpel()));
//		
//		Speelsteen[] speelstenen = spel.getStapelStenenSpel();
//		
//		speelstenen[1] = new Speelsteen();
		spel.setStapelStenenSpel();
		
		return spel;
	}

   public Spel addSpel(Spel spel) {
	   System.out.println("Spel gemaakt");
	   Speelsteen[] speelstenen = new Speelsteen[16];
	   System.out.println(Arrays.toString(speelstenen));
	   spel.setStapelStenenSpel();
	   return spelrepository.save(spel);
	}
   
   
}
   
