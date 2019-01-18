package com.codeup.ticketsup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MovieController {
    @GetMapping("/order")
    public String index(Model model) {
        model.addAttribute("posts",postService.all());
        return "posts/index";
    }

    g("/posts")
    public String index(Model model) {
        posts = new ArrayList<>();
        posts.add(new Post("New Post 1", "lorem impsum dolor set amit",1));
        posts.add(new Post("New Post 2", "lorem impsum dolor set amit", 2));
        posts.add(new Post("New Post 3", "lorem impsum dolor set amit", 3));
        posts.add(new Post("New Post 4", "lorem impsum dolor set amit", 4));
        model.addAttribute("posts",posts);
        return "posts/index";
    }
}
