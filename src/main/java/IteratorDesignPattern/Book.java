package IteratorDesignPattern;

public class Book {
    private String name;
    private int price;

    Book(int price, String bookName) {
        this.price = price;
        this.name = bookName;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}
