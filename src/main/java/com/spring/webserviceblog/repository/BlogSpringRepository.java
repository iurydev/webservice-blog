package com.spring.webserviceblog.repository;

import com.spring.webserviceblog.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogSpringRepository extends JpaRepository<PostModel, Long> {

}
