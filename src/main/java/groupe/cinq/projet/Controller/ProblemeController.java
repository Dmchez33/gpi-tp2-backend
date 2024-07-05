package groupe.cinq.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Service.ProblemeService;

@RestController
@RequestMapping("/api/problemes")
public class ProblemeController {

    @Autowired
    private ProblemeService service;

    @PostMapping
    public ResponseEntity<Probleme> createProbleme(@RequestBody Probleme probleme) {
        return new ResponseEntity<>(service.saveProbleme(probleme), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Probleme>> getAllProblemes() {
        return new ResponseEntity<>(service.getAllProblemes(), HttpStatus.OK);
    }

    @GetMapping("/ordinateurId")
    public ResponseEntity<List<Probleme>> getAllProblemesOrdinateur(@RequestParam("ordiId") Long id) {
        return new ResponseEntity<>(service.getAllProblemesByOrdinateur(id), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Probleme>> getProblemeId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getProblemeId(id), HttpStatus.OK);
    }
}
