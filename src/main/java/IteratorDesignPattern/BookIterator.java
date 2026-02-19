package IteratorDesignPattern;

import java.util.List;

public class BookIterator implements Iterator{

    private List<Book> bookList;
    private int index = 0;

    public BookIterator(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean hasNext() {
        return index < bookList.size();
    }

    @Override
    public Object next() {
        Book book = null;
        if(hasNext()) {
            book = bookList.get(index++);
        }
        return book;
    }
}
