package it.intesys.snackbar.snackbar.controller;


import it.intesys.snackbar.snackbar.service.SnackService;
import it.intesys.snackbar.snackbar.service.VendingMachineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api")
@RestController
public class AdminController {
    private final SnackService snackService;
    private final VendingMachineService vendingMachineService;


    public AdminController(SnackService snackService, VendingMachineService vendingMachineService) {
        this.snackService = snackService;
        this.vendingMachineService = vendingMachineService;
    }

    @GetMapping("/give-price")
    public Map<String, Double> givePrice(@RequestParam Map<String, String> snacks) {
        return vendingMachineService.givePrices(snacks);
    }

    @GetMapping("/refill-machine")
    public Map<String, Integer> addMoney(@RequestParam Map<String, String> snacks) {
        return vendingMachineService.refillSnacks(snacks);
    }


}
