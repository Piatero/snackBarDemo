package it.intesys.snackbar.snackbar.service;

import it.intesys.snackbar.snackbar.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class SnackService {

    private final UserRepository userRepository;

    public SnackService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean orderSnack (String user, String snack) {

        if (!userRepository.userExists(user)) {
            throw new IllegalArgumentException("User " + user + " does not exist");
        }


        // verifico utente ha soldi nel wallet
        // verifico se esiste lo snack e se è disponibile

        // scalo i soldi dal wallet dell'utente
        // scalo la disponibilità dello snack

        // verifico se snack cade

        return true;
    }

}
