package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.PriceRepository;
import it.intesys.snackbar.snackbar.repository.SnackRepository;
import it.intesys.snackbar.snackbar.repository.UserRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SnackService {

    private static final Logger log = LoggerFactory.getLogger(SnackService.class);

    private final SnackRepository snackRepository;
    private final PriceRepository priceRepository;

    public SnackService(SnackRepository snackRepository, PriceRepository priceRepository) {
        this.snackRepository = snackRepository;
        this.priceRepository = priceRepository;
    }

    public Boolean snackExists(String snack) {
        return snackRepository.snackExists(snack);
    }

    public Boolean snackAvailable(String snack) {
        return snackRepository.snackAvailable(snack);
    }

    public Double snackPriceBySnackId(String snack) {
        return priceRepository.getPriceBySnackId(snack);
    }

    public Integer decrementAvailable(String snack) {
        return snackRepository.decrementAvailable(snack);
    }

    public Double setNewPriceForSnackId(String snack, Double newPrice) {
        return priceRepository.setNewPriceForSnackId(snack, newPrice);
    }

    public Map<String, Integer> refillSnacks(Map<String, String> snacks) {
        return snackRepository.refillSnacksToMachine(snacks);
    }
}
