package IteratorDesignPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Book> bookList = Arrays.asList(new Book(200, "To Kill A Mockingbird"),
                new Book(150, "Rich Dad Poor Dad"),
                new Book(260, "Thinking, Fast and Slow"),
                new Book(440, "Ikigai"));

        List<Book> books = new ArrayList<>();
        books.add(new Book(165, "Maths"));
        books.add(new Book(200, "Science"));
        books.add(new Book(210, "English"));
        books.add(new Book(140, "Social Science"));

        Library bookShop = new Library(books);
        Iterator bookShopIterator = bookShop.createIterator();

        Library library = new Library(bookList);
        Iterator iterator = library.createIterator();

        while(iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
        System.out.println("\n");
        while(bookShopIterator.hasNext()) {
            Book book = (Book) bookShopIterator.next();
            System.out.println(book.getName());
        }
    }
}
