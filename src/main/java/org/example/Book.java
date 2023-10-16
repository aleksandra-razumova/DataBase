package org.example;

public class Book {
    private int book_id;
    private String book_name;
    private int number_of_pages;
    private int author_id;

    public Book(int book_id, String book_name, int number_of_pages, int author_id) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.number_of_pages = number_of_pages;
        this.author_id = author_id;
    }


    @Override
    public String toString() {
        return "Book[" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", author_id=" + author_id +
                ']';
    }
}
