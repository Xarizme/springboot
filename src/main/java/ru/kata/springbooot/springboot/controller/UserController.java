package ru.kata.springbooot.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.springbooot.springboot.Service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(method = RequestMethod.GET, name = "Users", value = "/users")
    public String printUsers(ModelMap model) {
        model.addAttribute("people", userService.getAllUsers());
        return "users";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users/edit")
    public String printOneUser(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeById(id);
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/add")
    public String showAddUserPage() {
        return "add";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("age") int age,
                          @RequestParam("email") String email) {
        userService.saveUser(name, age, email);

        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/edit")
    public String updateUser(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("age") int age,
                             @RequestParam("email") String email) {
        userService.updateUser(id, name,age,email);

        return "redirect:/users";
    }
}
