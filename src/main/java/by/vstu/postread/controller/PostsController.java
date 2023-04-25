package by.vstu.postread.controller;

import by.vstu.postread.entity.Posts;
import by.vstu.postread.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public String newPost() {
        return "page1";
    }

    @PostMapping
    public String savePost(Posts post) {


        return "redirect:/"+postsService.savePost(post);
    }

    @GetMapping("/{url}")
    public String getPost(@PathVariable String url, Model model) {

        model.addAttribute("post", postsService.getPost(url));
        return "page2";
    }
}
