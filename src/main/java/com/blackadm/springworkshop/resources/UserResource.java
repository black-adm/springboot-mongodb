package com.blackadm.springworkshop.resources;

import com.blackadm.springworkshop.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @GetMapping
    public List<User> findAll() {
        User maria = new User(1, "Maria", "maria@gmail.com");
        User lucas = new User(2, "Lucas", "lucas@gmail.com");

        return new ArrayList<>(Arrays.asList(maria, lucas));
    }
}
