package com.restQuest.restQuest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    private String author;
    private String title;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public Book(String author, String title, String description, int ID) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.ID = ID;
    }

    public Book(){}

    public Book(String author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
