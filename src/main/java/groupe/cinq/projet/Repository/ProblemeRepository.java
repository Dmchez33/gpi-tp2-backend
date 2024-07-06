package groupe.cinq.projet.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Model.Probleme;

/**
 * Repository pour l'entité Probleme. Fournit des méthodes pour interagir avec
 * la base de données.
 */
public interface ProblemeRepository extends JpaRepository<Probleme, Long> {

    /**
     * Récupère le nombre de problèmes par type de système d'exploitation sur les
     * trois derniers mois.
     * 
     * @return une liste de cartes contenant le type de système d'exploitation et
     *         le nombre de problèmes.
     */
    @Query(value = "SELECT o.typese AS typeSE, COUNT(p.id) AS count FROM Probleme p, ordinateur o WHERE (p.ordinateur_id = o.id) AND p.date_probleme >= DATE_SUB(DATE_FORMAT(NOW() ,'%Y-%m-01'), INTERVAL 3 MONTH) AND date_probleme < DATE_FORMAT(NOW() ,'%Y-%m-01') GROUP BY o.typese", nativeQuery = true)
    List<Map<String, Object>> getProblemesParSE();

    /**
     * Récupère la fréquence des problèmes par description dans une période donnée.
     * 
     * @param startDate la date de début de la période.
     * @param endDate   la date de fin de la période.
     * @return une liste de cartes contenant la description du problème et le nombre
     *         de fois qu'il est survenu.
     */
    @Query("SELECT p.description AS description, COUNT(p) AS count FROM Probleme p WHERE p.dateProbleme BETWEEN :startDate AND :endDate GROUP BY p.description ORDER BY count DESC")
    List<Map<String, Object>> getProblemesParFrequence(@Param("startDate") LocalDate startDate,
                                                       @Param("endDate") LocalDate endDate);

    /**
     * Récupère les fréquences des problèmes par description et par date dans une
     * période donnée.
     * 
     * @param startDate la date de début de la période.
     * @param endDate   la date de fin de la période.
     * @return une liste de cartes contenant la description du problème, la date et
     *         le nombre de fois qu'il est survenu.
     */
    @Query("SELECT new map(p.description as probleme, p.dateProbleme as date, COUNT(p) as count) " +
           "FROM Probleme p WHERE p.dateProbleme BETWEEN :startDate AND :endDate " +
           "GROUP BY p.description, p.dateProbleme ORDER BY p.description, p.dateProbleme")
    List<Map<String, Object>> getProblemesParFrequences(@Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate);

    /**
     * Trouve tous les problèmes associés à un ordinateur spécifique.
     * 
     * @param ordinateur l'ordinateur dont on veut trouver les problèmes.
     * @return une liste de problèmes associés à l'ordinateur spécifié.
     */
    List<Probleme> findProblemeByOrdinateur(Ordinateur ordinateur);
}
