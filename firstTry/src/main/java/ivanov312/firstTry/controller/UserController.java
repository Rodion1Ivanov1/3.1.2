package ivanov312.firstTry.controller;

import ivanov312.firstTry.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ivanov312.firstTry.model.User;


//Заходить на страницу по /users
@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userServiceImpl.listUsers());
        return "users";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImpl.deleteUser(id);
        return "redirect:/users";
    }


    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userServiceImpl.showUser(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(User user) {
        userServiceImpl.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String getUserForm(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }


    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.saveUser(user);
        return "redirect:/users";
    }


}