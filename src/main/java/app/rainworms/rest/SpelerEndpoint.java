package app.rainworms.rest;

import app.rainworms.controller.DobbelsteenService;
import app.rainworms.controller.SpeelSteenService;
import app.rainworms.controller.SpelerService;
import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Speelsteen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/speler")
public class SpelerEndpoint {
    @Autowired
    SpelerService spelerService;

    @Autowired
    DobbelsteenService dobbelsteenService;

    @GetMapping("/worp")
    public int getWorpDobbelsteen(){
        return dobbelsteenService.getWorp();
    }

//    public void addUrenFormulierToGebruiker(long gebruikerId, long urenformulierId) {
//        Gebruiker gebruiker = gebruikerRepository.findById(gebruikerId).get();
//        UrenFormulier uf = urenformulierrepository.findById(urenformulierId).get();
//        gebruiker.addUrenFormulierToArray(uf);
//        gebruikerRepository.save(gebruiker);
//    }

    }


