package by.vstu.postread.controller;

import by.vstu.postread.entity.User;
import by.vstu.postread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegistr() {
        return "register";
    }

    @PostMapping(value = "/register")
    public String postRegister(User user) {
        System.out.println(user.toString());
        boolean is = userService.register(user);
        if (is) {
            return "redirect:/login";
        }
        return "redirect:/register";
    }
}
