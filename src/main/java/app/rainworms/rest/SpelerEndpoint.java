package app.rainworms.rest;

import app.rainworms.controller.DobbelsteenService;
import app.rainworms.controller.SpeelSteenService;
import app.rainworms.controller.SpelerService;
import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Speelsteen;
import app.rainworms.model.Speler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/speler")
public class SpelerEndpoint {
    @Autowired
    SpelerService spelerservice;

    @Autowired
    DobbelsteenService dobbelsteenService;

    
    @PostMapping("/add-speler")
    public void addSpeler(@RequestBody Speler speler) {
    	spelerservice.addSpeler(speler);
    }
    
    @GetMapping("/speler/{id}")
    public Speler getSpelerById(@PathVariable(value = "id") long id) {
        System.out.println("speler opgevraagd");
        return spelerservice.getSpelerById(id);
    }
    
    @GetMapping("get-dobbelsteen-speler-by-id/{spelerid}/{dobbelsteenid}")
    public Dobbelsteen getDobbelsteenSpelerById(@PathVariable (value = "spelerid")Long spelerid, @PathVariable (value = "dobbelsteenid")Integer dobbelsteenid) {
    	
    	return spelerservice.getDobbelsteenFromSpelerById(spelerid, dobbelsteenid);
    }
    
    @CrossOrigin(origins = "http://localhost:8083")
    @PutMapping("/speler-dobbelstenen-pakken/{id}")
    public Speler setDobbelstenenSpelerById(@PathVariable(value = "id") long id) {
    	System.out.println("dobbelstenen geven aan speler");
    	return spelerservice.chainDobbelstenenToSpeler(id);
    }
    
    
    
    

//    public void addUrenFormulierToGebruiker(long gebruikerId, long urenformulierId) {
//        Gebruiker gebruiker = gebruikerRepository.findById(gebruikerId).get();
//        UrenFormulier uf = urenformulierrepository.findById(urenformulierId).get();
//        gebruiker.addUrenFormulierToArray(uf);
//        gebruikerRepository.save(gebruiker);
//    }

    }


