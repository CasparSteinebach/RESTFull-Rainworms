package app.rainworms.controller;

import app.rainworms.model.Dobbelsteen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DobbelSteenRepository extends CrudRepository<Dobbelsteen, Long> {
}
