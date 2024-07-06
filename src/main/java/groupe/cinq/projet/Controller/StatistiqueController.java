package groupe.cinq.projet.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Service.StatistiqueService;

/**
 * Contrôleur REST pour gérer les statistiques liées aux interventions.
 */
@RestController
@RequestMapping("/api/statistiques")
public class StatistiqueController {

    @Autowired
    private StatistiqueService statistiqueService;

    /**
     * Récupère le nombre de problèmes par spécialiste en support technique.
     *
     * @return ResponseEntity contenant une liste de maps associant chaque spécialiste à son nombre de problèmes et le statut HTTP 200 si réussi.
     */
    @GetMapping("/problemes-par-se")
    public ResponseEntity<List<Map<String, Object>>> getProblemesParSE() {
        return new ResponseEntity<>(statistiqueService.getProblemesParSE(), HttpStatus.OK);
    }

    /**
     * Récupère la durée moyenne des interventions.
     *
     * @return ResponseEntity contenant la durée moyenne des interventions et le statut HTTP 200 si réussi.
     */
    @GetMapping("/duree-moyenne-intervention")
    public ResponseEntity<Double> getDureeMoyenneIntervention() {
        return new ResponseEntity<>(statistiqueService.getDureeMoyenneIntervention(), HttpStatus.OK);
    }

    /**
     * Récupère le nombre de problèmes par fréquence sur une période donnée.
     *
     * @param startDate Date de début de la période (format ISO DATE).
     * @param endDate   Date de fin de la période (format ISO DATE).
     * @return ResponseEntity contenant une liste de maps associant chaque fréquence de problème à son nombre et le statut HTTP 200 si réussi.
     */
    @GetMapping("/problemes-par-frequence")
    public ResponseEntity<List<Map<String, Object>>> getProblemesParFrequence(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(statistiqueService.getProblemesParFrequence(startDate, endDate), HttpStatus.OK);
    }

    /**
     * Récupère le nombre de problèmes par fréquence sur une période donnée (version alternative sans ResponseEntity).
     *
     * @param startDate Date de début de la période (format ISO DATE).
     * @param endDate   Date de fin de la période (format ISO DATE).
     * @return Liste de maps associant chaque fréquence de problème à son nombre.
     */
    @GetMapping("/problemes-par-frequences")
    public List<Map<String, Object>> getProblemesParFrequences(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return statistiqueService.getProblemesParFrequences(startDate, endDate);
    }
}
