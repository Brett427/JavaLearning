package com;

public class Book {
    Integer id;


    String name;
    double price;
    String author;
    String organazition;

    public Book(Integer id,String name, double price, String author, String organazition) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.organazition = organazition;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOrganazition() {
        return organazition;
    }

    public void setOrganazition(String organazition) {
        this.organazition = organazition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
