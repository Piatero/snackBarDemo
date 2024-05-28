package it.intesys.snackbar.snackbar.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PriceRepository {
    private Map<String, Double> priceBySnackId;

    public PriceRepository() {
        priceBySnackId = new HashMap<>();

        priceBySnackId.put("Mars", 1.0);
        priceBySnackId.put("Twix", 1.0);
        priceBySnackId.put("Kinder Delice", 2.0);
    }

    public Double getPriceBySnackId(String snack) {
        return priceBySnackId.get(snack);
    }

    public Map.Entry<String, Double> setNewPriceForSnackId(String snack, Double newPrice) {
        Double nP = priceBySnackId.put(snack, newPrice);
        assert nP != null;
        return Map.entry(snack, nP);
    }





}
