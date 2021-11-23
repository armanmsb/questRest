package com.restQuest.restQuest;


import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //Create
    @PostMapping("/book")
    public boolean createBlog(@RequestBody List<Book> books){

        if(books.isEmpty()){
            return false;
        }else{
            for (Book b:books) {
                bookRepository.save(b);
            }
            return true;
        }
    }

    //Read
    @GetMapping("/book")
    public List<Book> findAllBooks(){

        return bookRepository.findAll();
    }

    //Update
    @PutMapping("/book/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book){

        int bookId = Integer.parseInt(id);
        Book b = bookRepository.findById(bookId).get();

        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());

        return bookRepository.save(b);
    }

    //Delete
    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        bookRepository.deleteById(bookId);
        return true;
    }

    //Search
    @PostMapping("/book/search")
    public List<Book> searchBook(@RequestBody Map<String, String> searchTerm){

        String title = searchTerm.get("title");
        String description = searchTerm.get("description");

        if(title != null && description==null){
            return bookRepository.findByTitleContaining(title);
        }else if(title == null && description!=null){
            return bookRepository.findByDescriptionContaining(description);
        }else{
            return bookRepository.findByTitleContainingOrDescriptionContaining(title, description);
        }

    }

}
