package groupe.cinq.projet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import groupe.cinq.projet.Model.User;
import groupe.cinq.projet.Service.UserService;

@SpringBootApplication
public class ProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetApplication.class, args);
	}
	

	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			if(userService.getAllUser().size() == 0)
				userService.saveUser(new User(null,"Idrissa","12345678","Admin"));
			
		};
	}

}
