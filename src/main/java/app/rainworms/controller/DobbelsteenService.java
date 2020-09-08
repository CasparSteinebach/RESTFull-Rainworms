package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Random;

@Service
@Transactional
public class DobbelsteenService {

    @Autowired
    DobbelSteenRepository dobbelSteenRepository;

    public Dobbelsteen getDobbelsteenById(long id) {
        return dobbelSteenRepository.findById(id).get();
    }

    public Dobbelsteen addDobbelsteen(Dobbelsteen dobbelsteen) {
        System.out.println("add Dobbelsteen gemaakt");
        return dobbelSteenRepository.save(dobbelsteen);
    }

    public int getWorp() {
        Random random = new Random();
        int worp = random.nextInt(6) + 1;
        return worp;
    }

    public Dobbelsteen setStatusDobbelsteen(long id) {
        Dobbelsteen dobbelsteen = getDobbelsteenById(id);

        if (dobbelsteen.getStatusSteen().equals("open")) {
            System.out.println(dobbelsteen.getStatusSteen());
            dobbelsteen.setStatusSteen("vast");
        } else if (dobbelsteen.getStatusSteen().equals("vast")) {
            System.out.println(dobbelsteen.getStatusSteen());
            dobbelsteen.setStatusSteen("open");
        }
        return dobbelsteen;
    }

    public Dobbelsteen setWorp(long id) {
        Dobbelsteen dobbelsteen = getDobbelsteenById(id);
        dobbelsteen.setWorp();
        System.out.println("gegooid: " + dobbelsteen.getWorp());
        return dobbelsteen;
    }

    public void addDobbelstenen(Dobbelsteen dobbelsteen) {
        for (int i = 0; i < 8; i++) {
            System.out.println("add Dobbelsteen gemaakt");
            dobbelSteenRepository.save(dobbelsteen);
        }
    }

    public Integer getWorpById(long id) {
        return dobbelSteenRepository.findById(id).get().getWorp();
    }
}