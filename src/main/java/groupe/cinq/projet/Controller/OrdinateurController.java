package groupe.cinq.projet.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Service.OrdinateurService;

/**
 * Contrôleur REST pour gérer les opérations sur les ordinateurs.
 */
@RestController
@RequestMapping("/api/ordinateurs")
public class OrdinateurController {

    @Autowired
    private OrdinateurService service;

    /**
     * Crée un nouvel ordinateur.
     *
     * @param ordinateur L'ordinateur à créer.
     * @return ResponseEntity contenant l'ordinateur créé et le statut HTTP 201 si réussi.
     */
    @PostMapping
    public ResponseEntity<Ordinateur> createOrdinateur(@RequestBody Ordinateur ordinateur) {
        return new ResponseEntity<>(service.saveOrdinateur(ordinateur), HttpStatus.CREATED);
    }

    /**
     * Récupère tous les ordinateurs.
     *
     * @return ResponseEntity contenant la liste de tous les ordinateurs et le statut HTTP 200 si réussi.
     */
    @GetMapping
    public ResponseEntity<List<Ordinateur>> getAllOrdinateurs() {
        return new ResponseEntity<>(service.getAllOrdinateurs(), HttpStatus.OK);
    }

    /**
     * Récupère un ordinateur par son identifiant.
     *
     * @param id L'identifiant de l'ordinateur à récupérer.
     * @return ResponseEntity contenant l'ordinateur trouvé et le statut HTTP 200 si réussi.
     */
    @GetMapping("/id")
    public ResponseEntity<Optional<Ordinateur>> getOrdinateurId(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getOrdinateurId(id), HttpStatus.OK);
    }
}
