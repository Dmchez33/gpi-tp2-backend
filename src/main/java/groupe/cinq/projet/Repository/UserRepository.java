package groupe.cinq.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe.cinq.projet.Model.User;

/**
 * Repository pour l'entité User. Fournit des méthodes pour interagir avec
 * la base de données.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Trouve un utilisateur par son nom d'utilisateur.
     * 
     * @param username le nom d'utilisateur à rechercher.
     * @return l'utilisateur associé au nom d'utilisateur spécifié.
     */
    User findByUsername(String username);
}
