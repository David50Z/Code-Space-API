package webspace.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args-> {
            User David = new User(
                    "David",
                    "Davidfriedchicken@gmail.com",
                    "redred12",
                    "default"
            );

            User Davidd = new User(
                    "David",
                    "Davidfriedchicken@gmail.com",
                    "redred12",
                    "default"
            );

            repository.save(David);
        };
    }
}
