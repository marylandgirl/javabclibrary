package com.example.javabclibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("book",bookRepository.getAllByBorrowedTrue());
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
            System.out.println(book.getTitle());
            System.out.println(result.getFieldError());

            return "addbooks";
        }
        bookRepository.save(book);
        return "redirect:/";
    }
}
