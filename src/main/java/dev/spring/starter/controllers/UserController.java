package dev.spring.starter.controllers;

import dev.spring.starter.dto.UserResponseDto;
import dev.spring.starter.model.User;
import dev.spring.starter.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectData() {
        userService.add(new User("User1", "login1", "password1"));
        userService.add(new User("User2", "login2", "password2"));
        userService.add(new User("User3", "login3", "password3"));
        userService.add(new User("User4", "login4", "password4"));
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        User user = userService.get(userId);
        return new UserResponseDto(user);
    }

    @GetMapping()
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        List<UserResponseDto> dtoList = new ArrayList<>();
        for (User u : users) {
            dtoList.add(new UserResponseDto(u));
        }
        return dtoList;
    }
}

