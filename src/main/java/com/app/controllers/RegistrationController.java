package com.app.controllers;

import com.app.model.User;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

   @GetMapping("/registration")
   public String getRegistrationPage(Model model) { // Model - для передачи данных
       model.addAttribute("userData", new User());
       return "registration";
   }

   @PostMapping("/registration")    //Попадаем сюда после нажатия кнопки Register!
   public String registerUser(@ModelAttribute User user, Model model) { //@ModelAttribute User user - получаем обьект User
       User validatedUser = userService.validateUser(user);
       model.addAttribute("status", validatedUser == null ? "error" : "success");
       model.addAttribute("user", validatedUser == null ? user : validatedUser);
       return "successRegistration";
   }
}
