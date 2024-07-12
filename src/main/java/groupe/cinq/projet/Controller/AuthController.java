package groupe.cinq.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.User;
import groupe.cinq.projet.Service.UserService;

/**
 * Contrôleur pour la gestion de l'authentification.
 * Gère les opérations de connexion et d'enregistrement des utilisateurs.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    /**
     * Authentifie un utilisateur en vérifiant son nom d'utilisateur et son mot de passe.
     * 
     * @param user l'utilisateur à authentifier.
     * @return les détails de l'utilisateur en cas de succès, sinon null.
     */
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser; // Retourne les détails de l'utilisateur en cas de succès
        }
        return null; // Retourne null ou une réponse d'erreur appropriée
    }

    /**
     * Enregistre un nouvel utilisateur. Si l'utilisateur existe déjà, retourne un message d'erreur.
     * 
     * @param user l'utilisateur à enregistrer.
     * @return une réponse HTTP avec les détails de l'utilisateur enregistré ou un message d'erreur.
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return new ResponseEntity<>("Ce compte existe déjà !", HttpStatus.OK); // Retourne un message d'erreur si l'utilisateur existe déjà
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK); // Retourne les détails de l'utilisateur enregistré
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
}
