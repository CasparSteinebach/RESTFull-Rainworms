package app.rainworms.controller;

import app.rainworms.model.Speelsteen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpeelsteenRepository extends CrudRepository<Speelsteen, Long> {
}
