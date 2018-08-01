package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postRegister(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age){
        User user = new User(age,name,email);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }
}
