package groupe.cinq.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Repository.OrdinateurRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;
import lombok.AllArgsConstructor;

/**
 * Service pour l'entité Probleme. Fournit des méthodes pour les opérations métier
 * liées aux problèmes rencontrés par les ordinateurs.
 */
@Service
@AllArgsConstructor
public class ProblemeService {

    private ProblemeRepository repository;
    private OrdinateurRepository ordinateurRepository;
    
    /**
     * Enregistre un nouveau problème.
     * 
     * @param probleme le problème à enregistrer.
     * @return le problème enregistré.
     */
    public Probleme saveProbleme(Probleme probleme) {
        return repository.save(probleme);
    }

    /**
     * Récupère tous les problèmes.
     * 
     * @return une liste de tous les problèmes.
     */
    public List<Probleme> getAllProblemes() {
        return repository.findAll();
    }

    /**
     * Récupère un problème par son identifiant.
     * 
     * @param id l'identifiant du problème.
     * @return un Optional contenant le problème correspondant s'il est trouvé, ou un Optional vide sinon.
     */
    public Optional<Probleme> getProblemeId(Long id) {
        return repository.findById(id);
    }

    /**
     * Récupère tous les problèmes associés à un ordinateur spécifique.
     * 
     * @param id l'identifiant de l'ordinateur.
     * @return une liste de problèmes associés à l'ordinateur.
     */
    public List<Probleme> getAllProblemesByOrdinateur(Long id) {
        System.out.println(id);
        Ordinateur ordinateur = ordinateurRepository.findById(id).get();
        return repository.findProblemeByOrdinateur(ordinateur);
    }
}
