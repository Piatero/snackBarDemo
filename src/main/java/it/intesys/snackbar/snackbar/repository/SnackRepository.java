package it.intesys.snackbar.snackbar.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SnackRepository {
    private final Map<String, Integer> quantityBySnackId;

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

    public Map.Entry<String, Integer> refillSnacksToMachine(String snack, Integer numAdded) {
        Integer n = quantityBySnackId.put(snack, quantityBySnackId.get(snack) + numAdded);
        assert n != null;
        return Map.entry(snack, n);
    }

}
