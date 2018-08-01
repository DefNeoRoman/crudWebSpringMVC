package app.controller;

import app.dao.UserDao;
import app.dao.UserDaoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    private UserDao userDao;
    public MainController() {
       userDao = UserDaoFactory.getUserDao();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users",userDao.getAllUsers(0,10));
        return modelAndView;
    }

    @RequestMapping(value = "/user")
    public ModelAndView checkUser() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("user","вася");
        return modelAndView;
    }
}
