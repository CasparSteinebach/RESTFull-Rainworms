package app.rainworms.model;

import app.rainworms.controller.DobbelsteenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Random;

@Entity
public class Dobbelsteen implements Werpen{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    private String statusSteen;
    private int worp;
    private int dobbelPuntenScore;

    public Dobbelsteen() {
        this.statusSteen = "open";
        //this.worp = getWorp();
    }

    public Dobbelsteen(String statusSteen) {

        this.statusSteen = statusSteen;
    }

    public Dobbelsteen(String statusSteen, int worp) {
        this.statusSteen = statusSteen;
        this.worp = worp;
    }

    public Dobbelsteen(Long id) {
        this.id = id;
    }

    public String getStatusSteen() {
        return statusSteen;
    }

    public void setStatusSteen(String statusSteen) {
        this.statusSteen = statusSteen;
    }

    public int getDobbelPuntenScore() {
        return dobbelPuntenScore;
    }

    public int getWorp() {
        return worp;
    }

    public void setWorp() {
        Random random = new Random();
        this.worp = random.nextInt(6) +1;
    }

    public void setDobbelPuntenScore(int dobbelPuntenScore) {
        this.dobbelPuntenScore = dobbelPuntenScore;
    }
}

