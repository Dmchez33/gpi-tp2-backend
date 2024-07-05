package groupe.cinq.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Intervention;
import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Repository.InterventionRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;

@Service
public class InterventionService {

    @Autowired
    private InterventionRepository repository;

    @Autowired
    private ProblemeRepository problemeRepository;

    public Intervention saveIntervention(Intervention intervention) {
        return repository.save(intervention);
    }

    public List<Intervention> getAllInterventions() {
        return repository.findAll();
    }

    public Intervention getInterventionById(Long id){
        return repository.findById(id).get();
    }

    public List<Intervention> getAllInterventionsByProbleme(Long idProbleme){
        Probleme probleme = problemeRepository.findById(idProbleme).get();
        return repository.findInterventionByProbleme(probleme);
    }
}

