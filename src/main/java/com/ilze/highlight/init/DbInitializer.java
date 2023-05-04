package com.ilze.highlight.init;

import com.ilze.highlight.repositories.GroupsRepository;
import com.ilze.highlight.repositories.UserRepository;
import com.ilze.highlight.entity.Groups;
import com.ilze.highlight.entity.enums.Role;
import com.ilze.highlight.entity.User;
import com.ilze.highlight.service.GroupsService;
import com.ilze.highlight.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.List;

//@Component
//@RequiredArgsConstructor
//public class DbInitializer implements CommandLineRunner {
//
//    private final UserRepository userRepository;
//    private final UserService userService;
//    private final GroupsRepository groupsRepository;
//    private final GroupsService groupsService;
//
//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        boolean usersExist = userRepository.count() > 0;
//        if (!usersExist) {
//            initializeDbWithMockData();
//        }
//    }
//
//    private void initializeDbWithMockData() {
//
////        INSERT INTO group_collection (create_time, description, group_name, open, strict, size)
////        VALUES (current_timestamp() ,'this is test this is test', 'We do', true, false, 10);
////
////        INSERT INTO group_collection (create_time, description, group_name, open, strict, size)
////        VALUES (current_timestamp() ,'all about cats', 'muris', true, true, 10);
//
//        Groups groups1 = new Groups();
//        groups1.setCreateTime(LocalDateTime.now());
//        groups1.setDescription("this is test this is test");
//        groups1.setGroupName("We do");
//        groups1.setOpen(true);
//        groups1.setStrict(false);
//        groups1.setSize(10);
//
//        Groups groups2 = new Groups();
//        groups2.setCreateTime(LocalDateTime.now());
//        groups2.setDescription("all about cats");
//        groups2.setGroupName("muris");
//        groups2.setOpen(true);
//        groups2.setStrict(true);
//        groups2.setSize(10);
//
//        var admin1 = new User();
//        admin1.setUsername("admin1.name");
//        admin1.setEmail("admin1@gmail.com");
//        admin1.setPassword("admin1.pass");
//        admin1.setRole(Role.ADMIN);
//        admin1.setCreateTime(LocalDateTime.now());
////        admin1.setGroupName(List.of(groups1, groups2));
//
//        var user1 = new User();
//        user1.setUsername("user1.name");
//        user1.setEmail("user1@gmail.com");
//        user1.setPassword("user1.pass");
//        user1.setRole(Role.USER);
//        user1.setCreateTime(LocalDateTime.now());
////        user1.setGroupName(List.of(groups2));
//
//        List<User> mockUsers = List.of(admin1, user1);
//        mockUsers.forEach(userService::saveUser);
//
//        userService.changeRole(Role.ADMIN, admin1.getUsername()); //in current implementation userService creates new user with default role USER, we need to modify it manually
//    }
//}
