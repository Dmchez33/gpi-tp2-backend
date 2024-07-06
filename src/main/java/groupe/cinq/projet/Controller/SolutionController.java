package groupe.cinq.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.Solution;
import groupe.cinq.projet.Service.SolutionService;

/**
 * Contrôleur REST pour gérer les opérations sur les solutions.
 */
@RestController
@RequestMapping("/api/solutions")
public class SolutionController {

    @Autowired
    private SolutionService service;

    /**
     * Crée une nouvelle solution.
     *
     * @param solution La solution à créer.
     * @return ResponseEntity contenant la solution créée et le statut HTTP 201 si réussi.
     */
    @PostMapping
    public ResponseEntity<Solution> createSolution(@RequestBody Solution solution) {
        return new ResponseEntity<>(service.saveSolution(solution), HttpStatus.CREATED);
    }

    /**
     * Récupère toutes les solutions.
     *
     * @return ResponseEntity contenant la liste de toutes les solutions et le statut HTTP 200 si réussi.
     */
    @GetMapping
    public ResponseEntity<List<Solution>> getAllSolutions() {
        return new ResponseEntity<>(service.getAllSolutions(), HttpStatus.OK);
    }

    /**
     * Récupère une solution par son identifiant.
     *
     * @param id L'identifiant de la solution à récupérer.
     * @return ResponseEntity contenant la solution trouvée et le statut HTTP 200 si réussi.
     */
    @GetMapping("/id")
    public ResponseEntity<Solution> getSolutionById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getSolutionById(id), HttpStatus.OK);
    }

    /**
     * Récupère toutes les solutions associées à un problème spécifique.
     *
     * @param idP L'identifiant du problème pour lequel récupérer les solutions.
     * @return ResponseEntity contenant la liste des solutions associées au problème et le statut HTTP 200 si réussi.
     */
    @GetMapping("/problemeId")
    public ResponseEntity<List<Solution>> getAllSolutionsByProbleme(@RequestParam("idP") Long idP) {
        return new ResponseEntity<>(service.getAllSolutionsByProbleme(idP), HttpStatus.OK);
    }
}
