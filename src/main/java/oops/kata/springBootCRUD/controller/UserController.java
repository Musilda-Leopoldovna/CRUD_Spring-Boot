package oops.kata.springBootCRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import oops.kata.springBootCRUD.model.User;
import oops.kata.springBootCRUD.services.UserService;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/")
    public String getUsersList(@RequestParam(value = "editId",required = false) Long editId,
                               @ModelAttribute User user, ModelMap model) {
        if (editId != null) {
            User editUser = service.getUserById(editId);
            model.addAttribute("editUser", editUser);
        }
        model.addAttribute("userList", service.getListOfUsers());
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(User user, ModelMap model) {
        this.service.addNewUser(user);
        model.addAttribute("userList", service.getListOfUsers());
        return "index";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("deleteById") Long ID) {
        service.removeUser(ID);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(User user, ModelMap model) {
        this.service.changeUser(user);
        model.addAttribute("userList", service.getListOfUsers());
        return "index";
    }
}
