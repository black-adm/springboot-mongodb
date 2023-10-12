package com.blackadm.springworkshop.services;

import com.blackadm.springworkshop.domain.User;
import com.blackadm.springworkshop.repository.UserRepository;
import com.blackadm.springworkshop.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findUserById(id);

        if (user == null) {
            throw new NotFoundException("Usuário não encontrado!");
        }
        return user;
    }
}
