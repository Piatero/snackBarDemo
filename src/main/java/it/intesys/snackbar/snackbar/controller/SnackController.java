package it.intesys.snackbar.snackbar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SnackController {
    @GetMapping("/order-snack")
    public Boolean orderSnack() {


        return true;
    }

}
