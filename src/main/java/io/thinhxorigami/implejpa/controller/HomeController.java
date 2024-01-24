package io.thinhxorigami.implejpa.controller;

import io.thinhxorigami.implejpa.model.User;
import io.thinhxorigami.implejpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor

@Controller
public class HomeController {

    private UserRepository userRepository;


    @GetMapping("/home")
    public String home(Model model) {

        if (userRepository.findAll().isEmpty()) {

            userRepository.save(
                    User.builder()
                            .name("thinhxorigami")
                            .passwd("1234")
                            .build()
            );
        }


        model.addAttribute("user", userRepository.findAll());

        return "home";
    }

}






















