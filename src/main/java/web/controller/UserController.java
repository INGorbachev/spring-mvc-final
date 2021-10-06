package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("users", userService.listUsers());
        return "index";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@ModelAttribute("id") Long id){
        userService.remove(id);
        return "redirect:/";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String updateUser(@ModelAttribute("id") Long id, Model model){
        User user = userService.getUserById(id) ;
        model.addAttribute("user",user);
        return "update";
    }
}
