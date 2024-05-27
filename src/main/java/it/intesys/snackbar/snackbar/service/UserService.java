package it.intesys.snackbar.snackbar.service;


import it.intesys.snackbar.snackbar.repository.UserRepository;
import it.intesys.snackbar.snackbar.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public UserService(UserRepository userRepository, WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }

    public Boolean userExists(String user) {
        return userRepository.userExists(user);
    }

    public Double getMoneyByUserId(String user) {
        return walletRepository.getMoneyByUserId(user);
    }

    public Double withdrawMoney(String user, Double amount) {
        return walletRepository.withdrawMoney(user, amount);
    }

    public Double addMoney(String user, Double amount) {
        return walletRepository.addMoney(user, amount);
    }
}
