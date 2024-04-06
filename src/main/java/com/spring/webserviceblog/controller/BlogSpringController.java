package com.spring.webserviceblog.controller;

import com.spring.webserviceblog.model.PostModel;
import com.spring.webserviceblog.service.BlogSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogSpringController {
    @Autowired
    BlogSpringService blogSpringService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<PostModel> posts = blogSpringService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }
}
