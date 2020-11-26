package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import app.rainworms.model.Speler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SpelerService {
    @Autowired SpelerRepository spelerRepository;
    
    public Speler addSpeler (Speler speler) {
        System.out.println("nieuwe speler toegevoegd");
        return spelerRepository.save(speler);
    }

}
