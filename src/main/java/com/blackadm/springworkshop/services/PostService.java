package com.blackadm.springworkshop.services;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.domain.User;
import com.blackadm.springworkshop.repository.PostRepository;
import com.blackadm.springworkshop.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(String id) {
        Post user = postRepository.findPostById(id);

        if (user == null) {
            throw new NotFoundException("Erro ao buscar posts para esse usuário!");
        }
        return user;
    }

    public List<Post> findPostByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
