package com.spring.webserviceblog.service;

import com.spring.webserviceblog.model.PostModel;

import java.util.List;

public interface BlogSpringService {
    List<PostModel> findAll();
    PostModel findById(long id);
    PostModel save(PostModel post);
}
