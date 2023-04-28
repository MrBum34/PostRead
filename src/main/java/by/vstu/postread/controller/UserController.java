package by.vstu.postread.controller;

import by.vstu.postread.entity.User;
import by.vstu.postread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//        User user=new User();
//        user.setUsername(username);
//        user.setPassword(password);
        System.out.println(user.toString());
        boolean is = userService.register(user);
        if (is){
            return "redirect:/login";
        }
        return "redirect:/register";
    }
}
