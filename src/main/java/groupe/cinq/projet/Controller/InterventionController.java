package groupe.cinq.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Service.InterventionService;

/**
 * Contrôleur REST pour gérer les opérations sur les interventions.
 */
@RestController
@RequestMapping("/api/interventions")
public class InterventionController {

    @Autowired
    private InterventionService service;

    /**
     * Crée une nouvelle intervention.
     *
     * @param intervention L'intervention à créer.
     * @return ResponseEntity contenant l'intervention créée et le statut HTTP 201 si réussi.
     */
    @PostMapping
    public ResponseEntity<Intervention> createIntervention(@RequestBody Intervention intervention) {
        return new ResponseEntity<>(service.saveIntervention(intervention), HttpStatus.CREATED);
    }

    /**
     * Récupère toutes les interventions.
     *
     * @return ResponseEntity contenant la liste de toutes les interventions et le statut HTTP 200 si réussi.
     */
    @GetMapping
    public ResponseEntity<List<Intervention>> getAllInterventions() {
        return new ResponseEntity<>(service.getAllInterventions(), HttpStatus.OK);
    }

    /**
     * Récupère une intervention par son identifiant.
     *
     * @param id L'identifiant de l'intervention à récupérer.
     * @return ResponseEntity contenant l'intervention trouvée et le statut HTTP 200 si réussi.
     */
    @GetMapping("/id")
    public ResponseEntity<Intervention> getInterventionById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getInterventionById(id), HttpStatus.OK);
    }

    /**
     * Récupère toutes les interventions associées à un problème spécifique.
     *
     * @param idP L'identifiant du problème pour lequel récupérer les interventions.
     * @return ResponseEntity contenant la liste des interventions et le statut HTTP 200 si réussi.
     */
    @GetMapping("/problemeId")
    public ResponseEntity<List<Intervention>> getAllInterventionsByProbleme(@RequestParam("idP") Long idP) {
        return new ResponseEntity<>(service.getAllInterventionsByProbleme(idP), HttpStatus.OK);
    }
}
