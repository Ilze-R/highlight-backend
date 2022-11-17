package com.ilze.highlight.init;

import com.ilze.highlight.dao.UserRepository;
import com.ilze.highlight.entity.Role;
import com.ilze.highlight.entity.User;
import com.ilze.highlight.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        boolean usersExist = userRepository.count() > 0;
        if (!usersExist) {
            initializeDbWithMockData();
        }
    }

    private void initializeDbWithMockData() {

        var admin1 = new User();
        admin1.setUsername("admin1.name");
        admin1.setEmail("admin1@gmail.com");
        admin1.setPassword("admin1.pass");
        admin1.setRole(Role.ADMIN);

        var user1 = new User();
        user1.setUsername("user1.name");
        user1.setEmail("user1@gmail.com");
        user1.setPassword("user1.pass");
        user1.setRole(Role.USER);

        List<User> mockUsers = List.of(admin1, user1);
        mockUsers.forEach(userService::saveUser);

        userService.changeRole(Role.ADMIN, admin1.getUsername()); //in current implementation userService creates new user with default role USER, we need to modify it manually
    }
}
