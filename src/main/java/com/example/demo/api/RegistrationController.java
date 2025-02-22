package com.example.demo.api;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Registration;
import com.example.demo.repo.RegistrationRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationRepository repository;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "register";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("registration") Registration registration, 
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        repository.save(registration);
        return "success";
    }

    @PostMapping("/reset")
    public String resetForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "register";
    }
}
