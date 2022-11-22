package webspace.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args-> {
            User David = new User(
                    "David",
                    "Davidfriedchicken@gmail.com",
                    "redred12",
                    "default",
                    Arrays.asList(new Playlist(
                            "Java"
                    ))
            );

            David.playlists.get(0).videos.add(new Video("https://www.youtube.com/watch?v=z81uQ87RnOU", "z81uQ87RnOU", "Galaxy something"));

            repository.save(David);
        };
    }
}
