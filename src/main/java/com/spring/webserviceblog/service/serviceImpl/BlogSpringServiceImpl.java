package com.spring.webserviceblog.service.serviceImpl;

import com.spring.webserviceblog.model.PostModel;
import com.spring.webserviceblog.repository.BlogSpringRepository;
import com.spring.webserviceblog.service.BlogSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSpringServiceImpl implements BlogSpringService {

    @Autowired
    BlogSpringRepository blogSpringRepository;

    @Override
    public List<PostModel> findAll() {
        return blogSpringRepository.findAll();
    }

    @Override
    public PostModel findById(long id) {
        return blogSpringRepository.findById(id).get();
    }

    @Override
    public PostModel save(PostModel post) {
        return blogSpringRepository.save(post);
    }

    @Override
    public void deletePost(PostModel post) {
        blogSpringRepository.delete(post);
    }
}
