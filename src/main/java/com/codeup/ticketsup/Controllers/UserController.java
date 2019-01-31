package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.User;
import com.codeup.ticketsup.models.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    private Users users;
    private PasswordEncoder passwordEncoder;

    private UserRepository userRepo;

    public UserController(Users users, PasswordEncoder passwordEncoder, UserRepository userRepo) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
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
    public String showUser(Model model){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userRepo.findOne(currentUser.getId());
        model.addAttribute("user", thisUser);
        return "user/showProfile";
    }

    @GetMapping("/editUser")
    public String getEditUserForm(Model model){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User thisUser = userRepo.findOne(currentUser.getId());
        model.addAttribute("user", thisUser);

        return "user/editProfile";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam(name = "first_name") String firstname,@RequestParam(name = "last_name") String lastname, @RequestParam(name = "phone") String phone,
                           @RequestParam(name = "username") String username, @RequestParam(name ="email") String email,
                           @RequestParam(name = "id") int id, @RequestParam(name = "zip_code") String zip_code , @RequestParam(name = "password") String password
                          , Model model){
        User thisUser = userRepo.findOne(id);
        thisUser.setFirst_name(firstname);
        thisUser.setLast_name(lastname);
        thisUser.setPhone(phone);
        thisUser.setEmail(email);
        thisUser.setusername(username);
        thisUser.setZip_code(zip_code);
        thisUser.setPassword(password);
        userRepo.save(thisUser);


        return "redirect:/profile";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model){
        return "about-us";
    }

}
