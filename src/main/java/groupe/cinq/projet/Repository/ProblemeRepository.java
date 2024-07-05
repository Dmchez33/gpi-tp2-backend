package groupe.cinq.projet.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Model.Probleme;

public interface ProblemeRepository extends JpaRepository<Probleme, Long> {

        @Query(value = "SELECT o.typese AS typeSE, COUNT(p.id) AS count FROM Probleme p, ordinateur o WHERE (p.ordinateur_id = o.id) AND p.date_probleme >= DATE_SUB(DATE_FORMAT(NOW() ,'%Y-%m-01'), INTERVAL 3 MONTH) AND date_probleme < DATE_FORMAT(NOW() ,'%Y-%m-01') GROUP BY o.typese", nativeQuery = true)
        List<Map<String, Object>> getProblemesParSE();

        @Query("SELECT p.description AS description, COUNT(p) AS count FROM Probleme p WHERE p.dateProbleme BETWEEN :startDate AND :endDate GROUP BY p.description ORDER BY count DESC")
        List<Map<String, Object>> getProblemesParFrequence(@Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        @Query("SELECT new map(p.description as probleme, p.dateProbleme as date, COUNT(p) as count) " +
                        "FROM Probleme p WHERE p.dateProbleme BETWEEN :startDate AND :endDate " +
                        "GROUP BY p.description, p.dateProbleme ORDER BY p.description, p.dateProbleme")
        List<Map<String, Object>> getProblemesParFrequences(@Param("startDate") LocalDate startDate,
                        @Param("endDate") LocalDate endDate);

        List<Probleme> findProblemeByOrdinateur(Ordinateur ordinateur);
}
