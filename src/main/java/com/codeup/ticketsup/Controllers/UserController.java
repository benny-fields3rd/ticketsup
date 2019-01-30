package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.User;
import com.codeup.ticketsup.models.Users;
import com.codeup.ticketsup.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private Users users;
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private UserRepository userRepo;

    public UserController(Users users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        Model user = model.addAttribute("user", new User());
        return "user/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser( @ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:login";
    }

    @GetMapping("/profile")
    public String showUser(User user, Model model){
        User currentUser = userRepo.getOne(1);
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userRepo.findOne(currentUser.getId());
        model.addAttribute("user", thisUser);
        model.addAttribute("sessionUser", userService.loggedInUser());
        model.addAttribute("showEditControls", userService.canEditProfile(user));
        return "user/showProfile";
    }

    @GetMapping("/user/profile")
    public String showProfile(Model viewModel){
        User logUser = userService.loggedInUser();

        if(logUser == null){
            viewModel.addAttribute("msg", "You need to be logged in to be able to see");
            return "error/custom";
        }

        return "redirect:/users/" + userService.loggedInUser().getId();
    }

//    @GetMapping("/users/{id}/edit")
//    public String showEditForm(@PathVariable int id, Model viewModel){
//        User user = usersRepository.getOne(id);
//        viewModel.addAttribute("user", user);
//        viewModel.addAttribute("showEditControls", usersService.canEditProfile(user));
//        return "user/edit";
//    }
}
