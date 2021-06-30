package com.exercise_blog_app.model.repository;

import com.exercise_blog_app.model.entity.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
