package com.restQuest.restQuest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingOrDescriptionContaining(String title, String description);
    List<Book> findByTitleContaining(String title);
    List<Book> findByDescriptionContaining(String title);


}
