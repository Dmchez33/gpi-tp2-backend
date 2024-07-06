package groupe.cinq.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Repository.OrdinateurRepository;

/**
 * Service pour l'entité Ordinateur. Fournit des méthodes pour les opérations métier
 * liées aux ordinateurs.
 */
@Service
public class OrdinateurService {

    @Autowired
    private OrdinateurRepository repository;

    /**
     * Enregistre un nouvel ordinateur.
     * 
     * @param ordinateur l'ordinateur à enregistrer.
     * @return l'ordinateur enregistré.
     */
    public Ordinateur saveOrdinateur(Ordinateur ordinateur) {
        return repository.save(ordinateur);
    }

    /**
     * Récupère tous les ordinateurs.
     * 
     * @return une liste de tous les ordinateurs.
     */
    public List<Ordinateur> getAllOrdinateurs() {
        return repository.findAll();
    }

    /**
     * Récupère un ordinateur par son identifiant.
     * 
     * @param id l'identifiant de l'ordinateur.
     * @return un Optional contenant l'ordinateur correspondant s'il est trouvé, ou un Optional vide sinon.
     */
    public Optional<Ordinateur> getOrdinateurId(Long id) {
        return repository.findById(id);
    }
}
