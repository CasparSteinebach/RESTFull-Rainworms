package app.rainworms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.rainworms.controller.DobbelsteenService;
import app.rainworms.controller.SpelService;
import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Spel;


@RestController
@RequestMapping("/api/spel")
public class SpelEndpoint {
	
	 @Autowired
	 DobbelsteenService dobbelsteenservice;
	 
	 @Autowired
	 SpelService spelservice;
	 
	@PostMapping("/new-spel")
	    public Spel addSpel(@RequestBody Spel spel) {
	        System.out.println("Nieuw Spel aangemaakt");
	        return spelservice.addSpel(spel);
	    }
	
	
	@CrossOrigin(origins = "http://localhost:8083")
    @PutMapping ("/new-stapelspeelstenen/{id}")
    public Spel addSpeelbord(@PathVariable (value = "id")long id) {
        return spelservice.setStapelStenen(id);
    }
	
	
	@CrossOrigin(origins = "http://localhost:8083")
    @PutMapping ("/add-speler/{spelid}/{spelerid}")
    public Spel addSpelerToSpel(@PathVariable (value = "spelid")Long id, @PathVariable (value = "spelerid")Long spelerid) {
        return spelservice.addSpelerToSpel(id, spelerid);
    }
	
}
