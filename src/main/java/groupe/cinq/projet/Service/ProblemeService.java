package groupe.cinq.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Model.Probleme;
import groupe.cinq.projet.Repository.OrdinateurRepository;
import groupe.cinq.projet.Repository.ProblemeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProblemeService {

    
    private ProblemeRepository repository;
    private OrdinateurRepository ordinateurRepository;
    

    public Probleme saveProbleme(Probleme probleme) {
        return repository.save(probleme);
    }

    public List<Probleme> getAllProblemes() {
        return repository.findAll();
    }

    public Optional<Probleme> getProblemeId(Long id) {
        return repository.findById(id);
    }

    public List<Probleme> getAllProblemesByOrdinateur(Long id) {
        System.out.println(id);
        Ordinateur ordinateur = ordinateurRepository.findById(id).get();

        return repository.findProblemeByOrdinateur(ordinateur);
    }

}
