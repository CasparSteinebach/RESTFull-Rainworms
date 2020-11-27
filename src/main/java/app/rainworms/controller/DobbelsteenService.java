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
            dobbelsteen.setStatusSteen("vast");
            System.out.println(dobbelsteen.getStatusSteen());
        } else if (dobbelsteen.getStatusSteen().equals("vast")) {
            dobbelsteen.setStatusSteen("open");
            System.out.println(dobbelsteen.getStatusSteen());
        }
        return dobbelsteen;
    }

    public Dobbelsteen setWorp(long id) {
        Dobbelsteen dobbelsteen = getDobbelsteenById(id);
        if (dobbelsteen.getStatusSteen().equals("open")) {
        	dobbelsteen.setWorp();
            System.out.println("gegooid: " + dobbelsteen.getWorp());
            return dobbelsteen;
        } else return dobbelsteen;
       
    }
    
    public Dobbelsteen resetSteen(long id) {
		Dobbelsteen dobbelsteen = getDobbelsteenById(id);
		dobbelsteen.resetWorp();
		dobbelsteen.resetStatus();
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

	public String getStatusById(long id) {
		return dobbelSteenRepository.findById(id).get().getStatusSteen();
	}

	public Integer getCalculatedScore() {
		Integer score = 0;
		for (int i = 1; i <= 8 ; i++) {
			Dobbelsteen dobbelsteen = getDobbelsteenById(i);
			if (dobbelsteen.getStatusSteen().equals("vast")) {
				score += dobbelsteen.getWorp();
				}
			}
		return score;
		}

	
		
}