package com.onlinebookstore.onlinebookstore.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinebookstore.onlinebookstore.Entities.Book;

public interface BookRepository extends JpaRepository<Book,Long> {

}
