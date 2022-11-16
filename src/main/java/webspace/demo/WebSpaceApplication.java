package webspace.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpaceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("*")
						.allowedMethods("*")
						.allowedOrigins("localhost:3000")
						.allowedOrigins("localhost:44394")
						.allowedHeaders("*")
						.allowCredentials(false)
						.maxAge(-1);
			}
		};
	}

}
