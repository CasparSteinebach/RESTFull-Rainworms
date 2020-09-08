package app.rainworms.controller;

import app.rainworms.model.Speler;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpelerRepository extends CrudRepository<Speler, Long>{

}
