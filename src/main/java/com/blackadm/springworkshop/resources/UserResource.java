package com.blackadm.springworkshop.resources;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.domain.User;
import com.blackadm.springworkshop.dtos.UserDto;
import com.blackadm.springworkshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = userService.findAll();
        List<UserDto> listDto = list.stream().map(UserDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = userService.fromDto(objDto);
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDto objDto, @PathVariable String id) {
        User obj = userService.fromDto(objDto);
        obj.setId(id);
        obj = userService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }
}
