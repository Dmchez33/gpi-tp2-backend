package groupe.cinq.projet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.Ordinateur;
import groupe.cinq.projet.Repository.OrdinateurRepository;

@Service
public class OrdinateurService {

    @Autowired
    private OrdinateurRepository repository;

    public Ordinateur saveOrdinateur(Ordinateur ordinateur) {
        return repository.save(ordinateur);
    }

    public List<Ordinateur> getAllOrdinateurs() {
        return repository.findAll();
    }

    public Optional<Ordinateur> getOrdinateurId(Long id) {
        return repository.findById(id);
    }
}
