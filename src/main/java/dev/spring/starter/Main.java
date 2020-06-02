package dev.spring.starter;

import dev.spring.starter.config.AppConfig;
import dev.spring.starter.model.User;
import dev.spring.starter.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("UserOne", "One", "One"));
        userService.add(new User("UserTwo", "Two", "Two"));
        userService.add(new User("UserThree", "Three", "Three"));

        for (User u : userService.listUsers()) {
            System.out.println(u);
        }
    }
}
