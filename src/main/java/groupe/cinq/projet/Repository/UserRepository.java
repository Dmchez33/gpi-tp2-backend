package groupe.cinq.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe.cinq.projet.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

