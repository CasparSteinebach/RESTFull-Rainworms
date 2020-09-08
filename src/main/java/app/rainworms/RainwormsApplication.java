package app.rainworms;

import app.rainworms.model.Spel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RainwormsApplication {

    public static void main(String[] args) {

        SpringApplication.run(RainwormsApplication.class, args);
        System.out.println("hij doet 't!");
    }

//    @EventListen//transactional is needed because of multiple modified queries within the same onApplication and then function     @Transactional     public void onApplicationEvent(ApplicationReadyEvent event) {         System.out.println("From app rdy event"); } Hoo zonder de comments 

}
