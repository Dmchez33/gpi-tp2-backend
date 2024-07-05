package groupe.cinq.projet.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe.cinq.projet.Service.StatistiqueService;

@RestController
@RequestMapping("/api/statistiques")
public class StatistiqueController {

    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping("/problemes-par-se")
    public ResponseEntity<List<Map<String, Object>>> getProblemesParSE() {
        
        return new ResponseEntity<>(statistiqueService.getProblemesParSE(), HttpStatus.OK);
    }

    @GetMapping("/duree-moyenne-intervention")
    public ResponseEntity<Double> getDureeMoyenneIntervention() {
        return new ResponseEntity<>(statistiqueService.getDureeMoyenneIntervention(), HttpStatus.OK);
    }

    @GetMapping("/problemes-par-frequence")
    public ResponseEntity<List<Map<String, Object>>> getProblemesParFrequence(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(statistiqueService.getProblemesParFrequence(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/problemes-par-frequences")
    public List<Map<String, Object>> getProblemesParFrequences(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return statistiqueService.getProblemesParFrequences(startDate, endDate);
    }
}

