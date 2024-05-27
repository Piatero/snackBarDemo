package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import it.intesys.snackbar.snackbar.repository.UserRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.springframework.stereotype.Component;

@Component
public class SnackService {

    private final UserRepository userRepository;
    private final SnackRepository snackRepository;
    private final WalletRepository walletRepository;
    private final PriceRepository priceRepository;

    public SnackService(UserRepository userRepository, SnackRepository snackRepository, WalletRepository walletRepository, PriceRepository priceRepository) {
        this.userRepository = userRepository;
        this.snackRepository = snackRepository;
        this.walletRepository = walletRepository;
        this.priceRepository = priceRepository;
    }

    public Boolean orderSnack (String user, String snack) {

        if (!userRepository.userExists(user)) {
            throw new IllegalArgumentException("User " + user + " does not exist");
        }

        if (!snackRepository.snackExists(snack)) {
            throw new IllegalArgumentException("Snack " + snack + " does not exist");
        }

        if (!snackRepository.snackAvailable(snack)) {
            throw new IllegalArgumentException("Snack " + snack + " is not available");
        }

        Double snackPrice = priceRepository.getPriceBySnackId(snack);
        Double userMoney = walletRepository.getMoneyByUserId(user);

        if (snackPrice > userMoney) {
            throw new IllegalArgumentException("User %s doesn't have enough money to buy %s".formatted(user, snack));
        }

        Double newBalance = walletRepository.withdrawMoney(user, snackPrice);
        Integer newSnackQuantity = snackRepository.decrementAvailable(snack);

        System.out.println("User %s now has %s euros".formatted(user, newBalance));
        System.out.println("Snack %s now has %s pieces available".formatted(snack, newSnackQuantity));




        // scalo i soldi dal wallet dell'utente
        // scalo la disponibilità dello snack

        // verifico se snack cade

        return true;
    }

    private Boolean snackTransaction() {

        return true;
    }

}
