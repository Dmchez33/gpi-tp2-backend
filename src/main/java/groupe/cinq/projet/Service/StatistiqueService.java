package groupe.cinq.projet.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Repository.InterventionRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;

@Service
public class StatistiqueService {

    @Autowired
    private ProblemeRepository problemeRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    public List<Map<String, Object>> getProblemesParSE() {
        return problemeRepository.getProblemesParSE();
    }

    public Double getDureeMoyenneIntervention() {
        return interventionRepository.getDureeMoyenneIntervention();
    }

    public List<Map<String, Object>> getProblemesParFrequence(LocalDate startDate, LocalDate endDate) {
        return problemeRepository.getProblemesParFrequence(startDate, endDate);
    }

    public List<Map<String, Object>> getProblemesParFrequences(LocalDate startDate, LocalDate endDate) {
        // List<Map<String, Object>> rawData = problemeRepository.getProblemesParFrequences(startDate, endDate);

        // // Transformer les données pour les structurer en problèmes avec des séries de fréquences
        // Map<String, List<Map<String, Object>>> groupedByProbleme = rawData.stream()
        //     .collect(Collectors.groupingBy(item -> (String) item.get("probleme")));

        // return groupedByProbleme.entrySet().stream()
        //     .map(entry -> {
        //         String probleme = entry.getKey();
        //         List<Map<String, Object>> frequences = entry.getValue();
        //         List<Map<String, Object>> series = frequences.stream()
        //             .map(freq -> Map.of("name", freq.get("date").toString(), "value", freq.get("count")))
        //             .collect(Collectors.toList());

        //         return Map.of("probleme", probleme, "series", series);
        //     })
        //     .collect(Collectors.toList());
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

