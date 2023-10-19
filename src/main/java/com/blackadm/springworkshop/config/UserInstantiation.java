package com.blackadm.springworkshop.config;

import com.blackadm.springworkshop.domain.Post;
import com.blackadm.springworkshop.dtos.AuthorDto;
import com.blackadm.springworkshop.dtos.CommentDto;
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

        userRepository.saveAll(Arrays.asList(alice, marcos, vitoria, fabiana));

        Post postOne = new Post(
                null, simpleDate.parse("14/10/2023"), "Vlog da nossa viagem", "Nesse post iremos detalhar como foi a nossa viagem para Recife.", new AuthorDto(vitoria)
        );
        Post postTwo = new Post(
                null, simpleDate.parse("27/09/2023"), "Segurança no Rio de Janeiro", "Como lidei com a questão da segurança no em um dos locais mais turisticos do RJ.", new AuthorDto(marcos)
        );
        Post postTree = new Post(
                null, simpleDate.parse("11/07/2023"), "A viciante cultura bahiana", "Me apaixonei pela cultura e culinária da Bahia na minha recente ida a Belo Horizonte.", new AuthorDto(fabiana)
        );
        Post postFour = new Post(
                null, simpleDate.parse("01/10/2023"), "Chocada com os preços das roupas de crianças", "Gente quando foi que as roupas para bebês e recéns nascidos subiram tanto nos preços ?", new AuthorDto(alice)
        );
        Post postFive = new Post(
                null, simpleDate.parse("16/10/2023"), "Silêncio da Uber na postura dos motoristas", "Ignorância e atitudes ridiculas dos Ubers quando chegam no local de embarque!", new AuthorDto(vitoria)
        );

        CommentDto commentOne = new CommentDto("Que lindo vi <3", simpleDate.parse("14/10/2023"), new AuthorDto(marcos));
        CommentDto commentTwo = new CommentDto("Todo cuidado é pouco nego, vamos vigiar!", simpleDate.parse("28/09/2023"), new AuthorDto(fabiana));
        CommentDto commentTree = new CommentDto("Como voltar nessa viagem ? Foi demaaaais", simpleDate.parse("01/10/2023"), new AuthorDto(vitoria));

        postOne.getComments().addAll(Arrays.asList(commentOne, commentTree));
        postTwo.getComments().addAll(Arrays.asList(commentTwo));
        postRepository.saveAll(Arrays.asList(postOne, postTwo, postTree, postFour, postFive));

        vitoria.getPosts().addAll(Arrays.asList(postOne, postFive));
        userRepository.save(vitoria);

    }
}
