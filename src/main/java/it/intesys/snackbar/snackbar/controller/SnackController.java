package it.intesys.snackbar.snackbar.controller;

import it.intesys.snackbar.snackbar.service.VendingMachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SnackController {

    private final VendingMachineService vendingMachineService;

    public SnackController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    @GetMapping("/order-snack")
    public Boolean orderSnack(@RequestParam("user") String user,
                              @RequestParam("snack") String snack) {

        return vendingMachineService.orderSnack(user, snack);
    }

}
