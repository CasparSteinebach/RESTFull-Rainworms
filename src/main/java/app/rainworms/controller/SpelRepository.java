package app.rainworms.controller;

import app.rainworms.model.Spel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpelRepository extends CrudRepository<Spel, Long> {
}
