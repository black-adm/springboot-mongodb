package com.blackadm.springworkshop.config;

import com.blackadm.springworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.blackadm.springworkshop.domain.User;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserInstantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User alice = new User(null, "Alice Cambui", "alice2023@gmail.com");
        User marcos = new User(null, "Marcos Roberto", "marcos.roberto@yahoo.com");
        User vitoria = new User(null, "Vitoria Cambui", "viviCambui@outlook.com");
        User fabiana = new User(null, "Fabiana Raquel", "fabiana_raquel@gmail.com");

        List<User> users = Arrays.asList(alice, marcos, vitoria, fabiana);
        userRepository.saveAll(users);    }
}
