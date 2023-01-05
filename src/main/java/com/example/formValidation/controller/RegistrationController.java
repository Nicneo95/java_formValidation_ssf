package com.example.formValidation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.formValidation.models.Person;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {

    @GetMapping
    public String getRegisterForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping
    // @Valid - Validate the data capture from the form by the model
    // BindingResult contains the validation results
    public String postRegistration(@Valid Person person, BindingResult binding, Model model) {
        // if got error return to register page
        if (binding.hasErrors()) {
            model.addAttribute("person", person);
            return "register";
        }
        return "thankyou";
    }
}
