package groupe.cinq.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Model.Solution;
import groupe.cinq.projet.Repository.ProblemeRepository;
import groupe.cinq.projet.Repository.SolutionRepository;

@Service
public class SolutionService {

    @Autowired
    private SolutionRepository repository;

    @Autowired
    private ProblemeRepository problemeRepository;

    public Solution saveSolution(Solution solution) {
        return repository.save(solution);
    }

    public List<Solution> getAllSolutions() {
        return repository.findAll();
    }

    public Solution getSolutionById(Long id){
        return repository.findById(id).get();
    }

    public List<Solution> getAllSolutionsByProbleme(Long idProbleme){
        Probleme probleme = problemeRepository.findById(idProbleme).get();
        return repository.findSolutionByProbleme(probleme);
    }
}

