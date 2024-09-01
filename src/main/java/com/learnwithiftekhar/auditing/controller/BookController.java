package com.learnwithiftekhar.auditing.controller;

import com.learnwithiftekhar.auditing.model.Book;
import com.learnwithiftekhar.auditing.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id, Model model) {
        return bookService.getBookById(id);
    }

    @GetMapping("/book/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "book/add";
    }

    @PostMapping("/book")
    public String addBook(@ModelAttribute("book") Book book, Model model) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/book/{id}/edit")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book/add";
    }
}
