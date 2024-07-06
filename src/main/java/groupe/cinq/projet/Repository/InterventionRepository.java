package groupe.cinq.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Model.Probleme;

/**
 * Repository pour l'entité Intervention. Fournit des méthodes pour interagir avec
 * la base de données.
 */
public interface InterventionRepository extends JpaRepository<Intervention, Long> {

    /**
     * Récupère la durée moyenne des interventions.
     * 
     * @return la durée moyenne des interventions en tant que Double.
     */
    @Query("SELECT AVG(i.dureeIntervention) FROM Intervention i")
    Double getDureeMoyenneIntervention();

    /**
     * Trouve toutes les interventions associées à un problème spécifique.
     * 
     * @param probleme le problème dont on veut trouver les interventions.
     * @return une liste d'interventions associées au problème spécifié.
     */
    List<Intervention> findInterventionByProbleme(Probleme probleme);
}
