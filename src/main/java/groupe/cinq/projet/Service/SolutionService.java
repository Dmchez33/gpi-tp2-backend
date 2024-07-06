package groupe.cinq.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Model.Solution;
import groupe.cinq.projet.Repository.ProblemeRepository;
import groupe.cinq.projet.Repository.SolutionRepository;

/**
 * Service pour l'entité Solution. Fournit des méthodes pour les opérations métier
 * liées aux solutions des problèmes rencontrés par les ordinateurs.
 */
@Service
public class SolutionService {

    @Autowired
    private SolutionRepository repository;

    @Autowired
    private ProblemeRepository problemeRepository;

    /**
     * Enregistre une nouvelle solution.
     * 
     * @param solution la solution à enregistrer.
     * @return la solution enregistrée.
     */
    public Solution saveSolution(Solution solution) {
        return repository.save(solution);
    }

    /**
     * Récupère toutes les solutions.
     * 
     * @return une liste de toutes les solutions.
     */
    public List<Solution> getAllSolutions() {
        return repository.findAll();
    }

    /**
     * Récupère une solution par son identifiant.
     * 
     * @param id l'identifiant de la solution.
     * @return la solution correspondante.
     */
    public Solution getSolutionById(Long id){
        return repository.findById(id).get();
    }

    /**
     * Récupère toutes les solutions associées à un problème spécifique.
     * 
     * @param idProbleme l'identifiant du problème.
     * @return une liste de solutions associées au problème.
     */
    public List<Solution> getAllSolutionsByProbleme(Long idProbleme){
        Probleme probleme = problemeRepository.findById(idProbleme).get();
        return repository.findSolutionByProbleme(probleme);
    }
}
