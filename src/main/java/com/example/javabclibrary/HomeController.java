package com.example.javabclibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/")
    public String showMain(){
        return "mainpage";
    }

    @GetMapping("/list")
    public String listBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "listbooks";
    }

    @GetMapping("/add")
    public String addBooks(Model model){
        model.addAttribute("book", new Book());
        return "addbooks";
    }

    @PostMapping("/processadd")
    public String processAdd(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if (result.hasErrors()){
            return "addbooks";
        }
        bookRepository.save(book);
        return "redirect:/list";
    }

    @GetMapping("/borrow")
    public String borrowBook(Model model){
        model.addAttribute("books",bookRepository.getAllByBorrowedFalse());
        return "borrowbooks";
    }

    @GetMapping("/borrow/{id}")
    public String showCourse(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookRepository.findOne(id));
        return "borrowone";
    }
}
