package com.library.model.repository;

import com.library.model.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBook extends PagingAndSortingRepository<Book, Long> {
}
