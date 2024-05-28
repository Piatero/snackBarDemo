package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.SnackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class VendingMachineService {

    private static final Logger log = LoggerFactory.getLogger(VendingMachineService.class);
    private final UserService userService;
    private final SnackService snackService;
    private final SnackRepository snackRepository;

    public VendingMachineService(UserService userService, SnackService snackService, SnackRepository snackRepository) {
        this.userService = userService;
        this.snackService = snackService;
        this.snackRepository = snackRepository;
    }

    public Boolean orderSnack (String user, String snack) {

        if (!userService.userExists(user)) {
            throw new IllegalArgumentException("User " + user + " does not exist");
        }

        if (!snackService.snackExists(snack)) {
            throw new IllegalArgumentException("Snack " + snack + " does not exist");
        }

        if (!snackService.snackAvailable(snack)) {
            throw new IllegalArgumentException("Snack " + snack + " is not available");
        }

        Double snackPrice = snackService.snackPriceBySnackId(snack);
        Double userMoney = userService.getMoneyByUserId(user);

        if (snackPrice > userMoney) {
            throw new IllegalArgumentException("User %s doesn't have enough money to buy %s".formatted(user, snack));
        }

        Double newBalance = userService.withdrawMoney(user, snackPrice);
        Integer newSnackQuantity = snackService.decrementAvailable(snack);

        if (!hasFallen()) {
            newBalance = userService.addMoney(user, snackPrice);
        }

        log.info("User {} now has {} euros", user, newBalance);
        log.info("Snack {} now has {} pieces available", snack, newSnackQuantity);

        return true;
    }

    public Map<String, Integer> refillSnacks (Map<String, String> snacks) {
        return snackService.refillSnacks(snacks);
    }

    public Map<String, Double> givePrices(Map<String, String> prices) {
        return snackService.setNewPricesForSnackIds(prices);
    }


    private Boolean hasFallen() {
        return Math.random() > .1;
    }
}
