package app.rainworms.controller;

import app.rainworms.model.Speelsteen;
import app.rainworms.model.Spel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class SpeelSteenService {
@Autowired SpeelsteenRepository speelsteenRepository;

}
