package com.blackadm.springworkshop.config;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.repository.PostRepository;
import com.blackadm.springworkshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.blackadm.springworkshop.domain.User;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class UserInstantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        simpleDate.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User alice = new User(null, "Alice Cambui", "alice2023@gmail.com");
        User marcos = new User(null, "Marcos Roberto", "marcos.roberto@yahoo.com");
        User vitoria = new User(null, "Vitoria Cambui", "viviCambui@outlook.com");
        User fabiana = new User(null, "Fabiana Raquel", "fabiana_raquel@gmail.com");

        Post postOne = new Post(
                null, simpleDate.parse("14/10/2023"), "Vlog da nossa viagem", "Nesse post iremos detalhar como foi a nossa viagem para Recife.", vitoria
        );
        Post postTwo = new Post(
                null, simpleDate.parse("27/09/2023"), "Segurança no Rio de Janeiro", "Como lidei com a questão da segurança no em um dos locais mais turisticos do RJ.", marcos
        );

        List<User> users = Arrays.asList(alice, marcos, vitoria, fabiana);
        userRepository.saveAll(users);

        List<Post> posts = Arrays.asList(postOne, postTwo);
        postRepository.saveAll(posts);
    }
}
