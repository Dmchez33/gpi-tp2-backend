package groupe.cinq.projet.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebMvcConfigs implements WebMvcConfigurer  {
   @Override
   public void addCorsMappings(CorsRegistry corsRegistry) {
       corsRegistry.addMapping("/**")
               .allowedOrigins("*")
               .allowedMethods("*")
               .maxAge(3600L)
               .allowedHeaders("*")
               .exposedHeaders("Authorization");
//                .allowCredentials(true);
   }

}