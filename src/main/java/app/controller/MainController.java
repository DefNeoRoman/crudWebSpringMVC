package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("users", userService.getAllUsers(0, 10));
        return modelAndView;
    }

    @RequestMapping(value = "/user")
    public ModelAndView checkUser() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", userService.getAllUsers(0, 10));
        return modelAndView;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView userCreate() {
        return new ModelAndView("create");
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String userCreatePost(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam int age
    ) {
        User user = new User(age, name, email);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public ModelAndView userEdit(@RequestParam Long id) {
        User userById = userService.getUserById(id);
        ModelAndView edit = new ModelAndView("edit");
        edit.addObject("user", userById);
        return edit;
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String userEditPost(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam String email,
                               @RequestParam int age
    ) {

        User userById = userService.getUserById(id);
        userById.setName(name);
        userById.setEmail(email);
        userById.setAge(age);
        userService.updateUser(userById);
        return "redirect:/user";
    }
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String userDelete(@RequestParam Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
    @RequestMapping(value = "/userTask", method = RequestMethod.GET)
    public String userTask(){

        return "userTask";
    }
}
