package it.intesys.snackbar.snackbar.repository;

import org.springframework.stereotype.Repository;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

@Repository
public class SnackRepository {
    private Map<String, Integer> quantityBySnackId;

    public SnackRepository() {
        quantityBySnackId = new HashMap<>();

        quantityBySnackId.put("Mars", 3);
        quantityBySnackId.put("Twix", 0);
        quantityBySnackId.put("Kinder Delice", 10);
    }

    public Boolean snackExists (String snack) {
        return quantityBySnackId.containsKey(snack);
    }

    public Boolean snackAvailable (String snack) {
        return quantityBySnackId.get(snack) > 0;
    }

    public Integer decrementAvailable(String snack) {
        quantityBySnackId.put(snack, quantityBySnackId.get(snack) - 1);
        return quantityBySnackId.get(snack);
    }



    public Map<String, Integer> refillSnacksToMachine(Map<String, String> snacks) {
        Map<String, Integer> added = new HashMap<>();
        snacks.forEach((key, value) -> {
            int intValue = Integer.parseInt(value);
            if (quantityBySnackId.containsKey(key)) {
                quantityBySnackId.put(key, quantityBySnackId.get(key) + intValue);
                added.put(key, intValue);
            }
        });
        return added;
    }

}
