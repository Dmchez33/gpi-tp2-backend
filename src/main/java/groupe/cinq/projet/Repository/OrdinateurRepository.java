package groupe.cinq.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe.cinq.projet.Model.Ordinateur;

public interface OrdinateurRepository extends JpaRepository<Ordinateur, Long> {
}

