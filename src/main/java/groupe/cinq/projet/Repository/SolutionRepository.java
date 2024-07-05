package groupe.cinq.projet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Model.Solution;

public interface SolutionRepository extends JpaRepository<Solution, Long> {

    List<Solution> findSolutionByProbleme(Probleme probleme);
}

