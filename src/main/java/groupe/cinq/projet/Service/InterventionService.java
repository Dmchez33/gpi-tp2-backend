package groupe.cinq.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Repository.InterventionRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;

/**
 * Service pour l'entité Intervention. Fournit des méthodes pour les opérations métier
 * liées aux interventions.
 */
@Service
public class InterventionService {

    @Autowired
    private InterventionRepository repository;

    @Autowired
    private ProblemeRepository problemeRepository;

    /**
     * Enregistre une nouvelle intervention.
     * 
     * @param intervention l'intervention à enregistrer.
     * @return l'intervention enregistrée.
     */
    public Intervention saveIntervention(Intervention intervention) {
        return repository.save(intervention);
    }

    /**
     * Récupère toutes les interventions.
     * 
     * @return une liste de toutes les interventions.
     */
    public List<Intervention> getAllInterventions() {
        return repository.findAll();
    }

    /**
     * Récupère une intervention par son identifiant.
     * 
     * @param id l'identifiant de l'intervention.
     * @return l'intervention correspondante.
     */
    public Intervention getInterventionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Récupère toutes les interventions associées à un problème spécifique.
     * 
     * @param idProbleme l'identifiant du problème.
     * @return une liste d'interventions associées au problème spécifié.
     */
    public List<Intervention> getAllInterventionsByProbleme(Long idProbleme) {
        Probleme probleme = problemeRepository.findById(idProbleme).orElse(null);
        if (probleme != null) {
            return repository.findInterventionByProbleme(probleme);
        } else {
            return null; // ou throw une exception si problème non trouvé
        }
    }
}
