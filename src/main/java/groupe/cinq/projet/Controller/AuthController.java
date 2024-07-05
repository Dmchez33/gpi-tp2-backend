package groupe.cinq.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import groupe.cinq.projet.Model.User;
import groupe.cinq.projet.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser; // Returning user details on successful login
        }
        return null; // Return null or an appropriate error response
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return new ResponseEntity<>("Ce compte existe déjà !", HttpStatus.OK); // Returning user details on successful login
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK); // Return null or an appropriate error response
    }
}

