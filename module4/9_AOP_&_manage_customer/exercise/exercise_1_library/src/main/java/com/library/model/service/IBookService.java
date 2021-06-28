package com.library.model.service;

import com.library.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAllBook();
    Book findBookById(long id);
    void saveBook(Book book);
    void deleteBook(long id);
    void borrowedBook(Book book);
    void bringBackBook(long id);
}
