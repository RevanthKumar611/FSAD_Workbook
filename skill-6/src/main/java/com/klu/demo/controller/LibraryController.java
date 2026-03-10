package com.klu.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.klu.demo.model.Book;

@RestController
public class LibraryController {

    List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int countBooks() {
        return 100;
    }

    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Spring Boot Guide");
        books.add("Machine Learning Basics");
        return books;
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book Added Successfully";
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}