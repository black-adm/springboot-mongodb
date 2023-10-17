package com.blackadm.springworkshop.repository;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post findPostById(String id);
}
