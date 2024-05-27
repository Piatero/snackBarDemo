package it.intesys.snackbar.snackbar.repository;

import java.util.HashMap;
import java.util.Map;

public class WalletRepository {
    private Map<String, Double> walletByUserId;

    public WalletRepository() {
        walletByUserId = new HashMap<>();

        walletByUserId.put("Pietro", 5.0);
        walletByUserId.put("Anna", 5.0);
        walletByUserId.put("Talha", 0.20);
    }

    public Double getMoneyByUserId(String user) {
        return walletByUserId.get(user);
    }

}