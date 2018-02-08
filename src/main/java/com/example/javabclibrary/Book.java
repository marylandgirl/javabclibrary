package com.example.javabclibrary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    @Size(min =4, max = 4)
    private int year;

    private String isbn;

    private String image;

    private Boolean borrowed;

    public Book() {
        setBorrowed(false);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }
}
