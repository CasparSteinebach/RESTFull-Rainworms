package app.rainworms.rest;

import app.rainworms.controller.DobbelsteenService;
import app.rainworms.model.Dobbelsteen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dobbelsteen")
public class DobbelsteenEndpoint {

    @Autowired
    DobbelsteenService dobbelsteenservice;

    @PostMapping("/new-dobbelsteen")
    public Dobbelsteen addDobbelsteen(@RequestBody Dobbelsteen dobbelsteen) {
        System.out.println("Dobbelsteen toegevoegd");
        return dobbelsteenservice.addDobbelsteen(dobbelsteen);
    }

    @PostMapping("/acht-dobbelstenen")
    public void addDobbelstenen(@RequestBody Dobbelsteen dobbelsteen){
        dobbelsteenservice.addDobbelstenen(dobbelsteen);
    }

    @GetMapping("/dobbelsteen/{id}")
    public Dobbelsteen getDobbelsteenById(@PathVariable(value = "id") long id) {
        System.out.println("Dobbelsteen opgevraagd");
        return dobbelsteenservice.getDobbelsteenById(id);
    }

    @GetMapping("/worp/{id}")
    public Integer getWorpById(@PathVariable(value = "id") long id) {
        System.out.println("Worp opgevraagd");
        return dobbelsteenservice.getWorpById(id);
    }
    
    @CrossOrigin(origins = "http://localhost:8083")
    @GetMapping("/checkstatus/{id}")
    public String getStatusById(@PathVariable(value = "id") long id) {
    	System.out.println("status opgevraagd");
    	return dobbelsteenservice.getStatusById(id);
    }
    
    @GetMapping("/getcalculatedscore")
    public Integer getCalculatedScore() {
    	return dobbelsteenservice.getCalculatedScore();
    }

    @CrossOrigin(origins = "http://localhost:8083")
    @PutMapping ("/changestatus/{id}")
    public Dobbelsteen changeStatusDobbelsteen(@PathVariable (value = "id")long id) {
        return dobbelsteenservice.setStatusDobbelsteen(id);
    }

    @PutMapping("/fillworp/{id}")
    public Dobbelsteen getWorpDobbelsteen(@PathVariable (value="id")long id) {
        return dobbelsteenservice.setWorp(id);
    }
    
    @PutMapping("/resetsteen/{id}")
    public Dobbelsteen resetWorpDobbelsteen(@PathVariable(value="id")long id) {
    	return dobbelsteenservice.resetSteen(id);
    }
    
}
