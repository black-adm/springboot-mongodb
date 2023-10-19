package com.blackadm.springworkshop.resources;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.resources.util.Url;
import com.blackadm.springworkshop.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text) {
            text = Url.decodeParam(text);
            List<Post> list = postService.findPostByTitle(text);
            return ResponseEntity.ok().body(list);
    }
}
