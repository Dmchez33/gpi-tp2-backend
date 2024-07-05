package groupe.cinq.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Model.Probleme;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {

    @Query("SELECT AVG(i.dureeIntervention) FROM Intervention i")
    Double getDureeMoyenneIntervention();

    List<Intervention> findInterventionByProbleme(Probleme probleme);
}


