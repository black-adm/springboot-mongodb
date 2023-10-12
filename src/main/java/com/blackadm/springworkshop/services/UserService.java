package com.blackadm.springworkshop.services;

import com.blackadm.springworkshop.domain.User;
import com.blackadm.springworkshop.dtos.UserDto;
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

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User update(User obj) {
        User newObj = userRepository.findUserById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDto(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
