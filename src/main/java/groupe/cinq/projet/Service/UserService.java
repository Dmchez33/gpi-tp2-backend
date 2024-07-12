package groupe.cinq.projet.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe.cinq.projet.Model.User;
import groupe.cinq.projet.Repository.UserRepository;

/**
 * Service pour la gestion des utilisateurs. Fournit des méthodes pour rechercher et sauvegarder des utilisateurs.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Recherche un utilisateur par son nom d'utilisateur.
     * 
     * @param username le nom d'utilisateur à rechercher.
     * @return l'utilisateur correspondant au nom d'utilisateur fourni, ou null s'il n'existe pas.
     */
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Sauvegarde un utilisateur dans le référentiel.
     * 
     * @param user l'utilisateur à sauvegarder.
     * @return l'utilisateur sauvegardé.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * get All User.
     * 
     * @return fournit la liste des utilisateurs disponibles dans la base de donnée
     */
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
