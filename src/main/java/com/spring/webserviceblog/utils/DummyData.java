package com.spring.webserviceblog.utils;

import com.spring.webserviceblog.model.PostModel;
import com.spring.webserviceblog.repository.BlogSpringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    BlogSpringRepository blogSpringRepository;

    //@PostConstruct
    public void savePosts(){

        List<PostModel> postList = new ArrayList<>();
        PostModel post1 = new PostModel();
        post1.setAutor("Bruno Alexandre");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        PostModel post2 = new PostModel();
        post2.setAutor("Michelli Brito");
        post2.setData(LocalDate.now());
        post2.setTitulo("API REST");
        post2.setTexto("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        postList.add(post1);
        postList.add(post2);

        for(PostModel post: postList){
            PostModel postSaved = blogSpringRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}