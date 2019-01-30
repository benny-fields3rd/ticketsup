package com.codeup.ticketsup.services;

import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    UserRepository usersRepo;

    public UserService (UserRepository userRepo) {
        this.usersRepo = userRepo;
    }

    public boolean isLoggedIn() {
        boolean isAnonymousUser =
                SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken;
        return ! isAnonymousUser;
    }

    // Returns a user obj directly from the DB
    public User loggedInUser() {

        if (! isLoggedIn()) {
            return null;
        }

        User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return usersRepo.findOne(sessionUser.getId());
    }

    // Edit controls are being showed up if the user is logged in and it's the same user viewing the file
    public boolean canEditProfile(User profileUser){
        return isLoggedIn() && (profileUser.getId() == loggedInUser().getId());
    }
}
