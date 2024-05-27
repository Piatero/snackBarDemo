package it.intesys.snackbar.snackbar.controller;

import it.intesys.snackbar.snackbar.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add-money")
    public Double addMoney(@RequestParam("user") String user,
                           @RequestParam("amount") Double amount) {

        return userService.addMoney(user, amount);
    }
}
