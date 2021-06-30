package com.library.controller;

import com.library.exception.BookException;
import com.library.model.entity.Book;
import com.library.model.service.IBookService;
import com.library.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LibraryController {
    @Autowired
    IBookService iBookService;
    @Autowired
    ICustomerService iCustomerService;

    //list book
    @GetMapping(value = "/home")
    public String showList(Model model) throws BookException {
        if (iBookService.findAllBook().isEmpty()){
            throw new BookException();
        }
        model.addAttribute("bookList", iBookService.findAllBook());
        return "/home";
    }

    //borrow book
    @GetMapping(value = "/borrow/{id}")
    public String showFormBorrow(@PathVariable(value = "id") long id,
                             Model model) {
        model.addAttribute("book",iBookService.findBookById(id));
        return "/view_book";
    }

    @PostMapping(value = "/borrow")
    public String borrowBook(@ModelAttribute("book") Book book, BindingResult bindingResult) throws BookException {
        if (book.getQuantity() == 0){
            throw new BookException();
        }
        iBookService.borrowedBook(book);
        return "/view_book";
    }

    // bring back
    @GetMapping(value = "/bring_back")
    public String showFormBringBack(){
        return "/bring_back";
    }

    @PostMapping(value = "/bring_back/{find}")
    public String bringBack(@PathVariable(value = "find") long id){
        return "/home";
    }

    // exception
    @ExceptionHandler(BookException.class)
    public String handleBookException(){
        return "error_library_exception";
    }
}
