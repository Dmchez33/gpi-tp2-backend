package groupe.cinq.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Service.ProblemeService;

/**
 * Contrôleur REST pour gérer les opérations sur les problèmes.
 */
@RestController
@RequestMapping("/api/problemes")
public class ProblemeController {

    @Autowired
    private ProblemeService service;

    /**
     * Crée un nouveau problème.
     *
     * @param probleme Le problème à créer.
     * @return ResponseEntity contenant le problème créé et le statut HTTP 201 si réussi.
     */
    @PostMapping
    public ResponseEntity<Probleme> createProbleme(@RequestBody Probleme probleme) {
        return new ResponseEntity<>(service.saveProbleme(probleme), HttpStatus.CREATED);
    }

    /**
     * Récupère tous les problèmes.
     *
     * @return ResponseEntity contenant la liste de tous les problèmes et le statut HTTP 200 si réussi.
     */
    @GetMapping
    public ResponseEntity<List<Probleme>> getAllProblemes() {
        return new ResponseEntity<>(service.getAllProblemes(), HttpStatus.OK);
    }

    /**
     * Récupère tous les problèmes associés à un ordinateur spécifique.
     *
     * @param id L'identifiant de l'ordinateur pour lequel récupérer les problèmes.
     * @return ResponseEntity contenant la liste des problèmes associés à l'ordinateur et le statut HTTP 200 si réussi.
     */
    @GetMapping("/ordinateurId")
    public ResponseEntity<List<Probleme>> getAllProblemesOrdinateur(@RequestParam("ordiId") Long id) {
        return new ResponseEntity<>(service.getAllProblemesByOrdinateur(id), HttpStatus.OK);
    }

    /**
     * Récupère un problème par son identifiant.
     *
     * @param id L'identifiant du problème à récupérer.
     * @return ResponseEntity contenant le problème trouvé et le statut HTTP 200 si réussi.
     */
    @GetMapping("/id")
    public ResponseEntity<Optional<Probleme>> getProblemeId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getProblemeId(id), HttpStatus.OK);
    }
}
