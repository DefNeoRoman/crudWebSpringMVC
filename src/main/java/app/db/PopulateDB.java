package app.db;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;
import java.util.UUID;

public class PopulateDB {
    @Autowired
    private UserService service;

    public void init() {
        Random random = new Random();

        User admin = new User(90, "admin", "admin@mail.com");
        admin.setRole("ROLE_ADMIN");
        admin.setPassword("admin");

        User regular = new User(12, "user", "user@mail.com");
        regular.setRole("ROLE_USER");
        regular.setPassword("user");
        try {
            service.addUser(admin);
            service.addUser(regular);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            User user = new User(
                    i + random.nextInt(),
                    UUID.randomUUID().toString(),
                    UUID.randomUUID() + "@MAIL.COM"

            );
            try {
                service.addUser(
                        user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
