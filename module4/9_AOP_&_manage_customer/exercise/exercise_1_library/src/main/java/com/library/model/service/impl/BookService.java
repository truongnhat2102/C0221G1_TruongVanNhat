package com.library.model.service.impl;

import com.library.model.entity.Book;
import com.library.model.repository.IBook;
import com.library.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBook iBook;

    @Override
    public List<Book> findAllBook() {
        return (List<Book>) iBook.findAll();
    }

    @Override
    public Book findBookById(long id) {
        return iBook.findById(id).orElse(null);
    }

    @Override
    public void saveBook(Book book) {
        iBook.save(book);
    }

    @Override
    public void deleteBook(long id) {
        iBook.deleteById(id);
    }

    @Override
    public void borrowedBook(Book book) {
        book.setQuantity(book.getQuantity()-1);
        iBook.save(book);
    }

    @Override
    public void bringBackBook(long id) {
        Book book = findBookById(id);
        book.setQuantity(book.getQuantity()-1);
        iBook.save(book);
    }
}
