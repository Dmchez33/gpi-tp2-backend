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

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Service.OrdinateurService;

@RestController
@RequestMapping("/api/ordinateurs")
public class OrdinateurController {

    @Autowired
    private OrdinateurService service;

    @PostMapping
    public ResponseEntity<Ordinateur> createOrdinateur(@RequestBody Ordinateur ordinateur) {
        return new ResponseEntity<>(service.saveOrdinateur(ordinateur), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ordinateur>> getAllOrdinateurs() {
        return new ResponseEntity<>(service.getAllOrdinateurs(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Ordinateur>> getOrdinateurId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getOrdinateurId(id), HttpStatus.OK);
    }
}

