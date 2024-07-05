package groupe.cinq.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Service.InterventionService;

@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

    @Autowired
    private InterventionService service;

    @PostMapping
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        return new ResponseEntity<>(service.saveIntervention(intervention), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Intervention>> getAllInterventions() {
        return new ResponseEntity<>(service.getAllInterventions(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Intervention> getInterventionById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getInterventionById(id), HttpStatus.OK);
    }

    @GetMapping("/problemeId")
    public ResponseEntity<List<Intervention>> getAllInterventionsByProbleme(@RequestParam("idP") Long idP) {
        return new ResponseEntity<>(service.getAllInterventionsByProbleme(idP), HttpStatus.OK);
    }
}

