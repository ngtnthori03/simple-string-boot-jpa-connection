package io.thinhxorigami.implejpa.config;

import io.thinhxorigami.implejpa.model.User;
import io.thinhxorigami.implejpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Command {

    @Bean
    public CommandLineRunner cmd(UserRepository userRepository) {

        return args ->  {
            if (userRepository.findAll().isEmpty()) {

                userRepository.save(
                        User.builder()
                                .name("thinhxorigami")
                                .passwd("1234")
                                .build()
                );
            }
        };
    }
}
