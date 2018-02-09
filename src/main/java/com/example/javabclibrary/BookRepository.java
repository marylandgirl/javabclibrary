package com.example.javabclibrary;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long>{

    public List<Book> getAllByBorrowedTrue();
    public List<Book> getAllByBorrowedFalse();
}
