package groupe.cinq.projet.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Repository.InterventionRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;

/**
 * Service pour les statistiques. Fournit des méthodes pour les calculs statistiques
 * liés aux problèmes et interventions des ordinateurs.
 */
@Service
public class StatistiqueService {

    @Autowired
    private ProblemeRepository problemeRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    /**
     * Récupère les problèmes par type de système d'exploitation.
     * 
     * @return une liste de cartes contenant le type de système d'exploitation et le nombre de problèmes associés.
     */
    public List<Map<String, Object>> getProblemesParSE() {
        return problemeRepository.getProblemesParSE();
    }

    /**
     * Récupère la durée moyenne des interventions.
     * 
     * @return la durée moyenne des interventions.
     */
    public Double getDureeMoyenneIntervention() {
        return interventionRepository.getDureeMoyenneIntervention();
    }

    /**
     * Récupère la fréquence des problèmes dans une plage de dates donnée.
     * 
     * @param startDate la date de début de la plage.
     * @param endDate la date de fin de la plage.
     * @return une liste de cartes contenant la description des problèmes et le nombre d'occurrences.
     */
    public List<Map<String, Object>> getProblemesParFrequence(LocalDate startDate, LocalDate endDate) {
        return problemeRepository.getProblemesParFrequence(startDate, endDate);
    }

    /**
     * Récupère les problèmes par fréquence et les structure en séries de données.
     * 
     * @param startDate la date de début de la plage.
     * @param endDate la date de fin de la plage.
     * @return une liste de cartes contenant les problèmes et les séries de fréquences.
     */
    public List<Map<String, Object>> getProblemesParFrequences(LocalDate startDate, LocalDate endDate) {
        List<Map<String, Object>> rawData = problemeRepository.getProblemesParFrequence(startDate, endDate);

        // Transformer les données pour les structurer en problèmes avec des séries de fréquences
        Map<String, List<Map<String, Object>>> groupedByProbleme = rawData.stream()
            .collect(Collectors.groupingBy(item -> (String) item.get("probleme")));

        return groupedByProbleme.entrySet().stream()
            .map(entry -> {
                String probleme = entry.getKey();
                List<Map<String, Object>> frequences = entry.getValue();
                List<Map<String, Object>> series = frequences.stream()
                    .map(freq -> Map.of("name", freq.get("date").toString(), "value", freq.get("count")))
                    .collect(Collectors.toList());

                return Map.of("probleme", probleme, "series", series);
            })
            .collect(Collectors.toList());
    }
}
