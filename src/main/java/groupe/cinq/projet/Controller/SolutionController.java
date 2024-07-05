package groupe.cinq.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import groupe.cinq.projet.Model.Solution;
import groupe.cinq.projet.Service.SolutionService;

@RestController
@RequestMapping("/api/solutions")
public class SolutionController {

    @Autowired
    private SolutionService service;

    @PostMapping
    public ResponseEntity<Solution> createSolution(@RequestBody Solution solution) {
        return new ResponseEntity<>(service.saveSolution(solution), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Solution>> getAllSolutions() {
        return new ResponseEntity<>(service.getAllSolutions(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Solution> getSolutionById(@RequestParam("id") Long id) {
        return new ResponseEntity<>(service.getSolutionById(id), HttpStatus.OK);
    }

    @GetMapping("/problemeId")
    public ResponseEntity<List<Solution>> getAllSolutionsByProbleme(@RequestParam("idP") Long idP) {
        return new ResponseEntity<>(service.getAllSolutionsByProbleme(idP), HttpStatus.OK);
    }
}
