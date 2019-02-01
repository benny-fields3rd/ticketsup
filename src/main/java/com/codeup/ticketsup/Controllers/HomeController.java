package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        if (AuthenticationSystem.isLogged()){
            User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User currentUser = userRepository.findOne(authenticatedUser.getId());
            model.addAttribute("user" , currentUser);
            if (currentUser.getusername().equals("admin")){
                return "redirect:admin/orders";
            }else {

                return "index";
            }
        }

        return "index";
    }
}
