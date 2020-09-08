package app.rainworms.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Spel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany
    private Set<Speelsteen> lijstStenen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
