/*
Theory Questions :
Explain linear search and binary search algorithms.

Answers :
Linear Search - It searches through the data structure one by one in a linear manner. O(n)
Binary Search - It works only on sorted structures, it divides search interval by half to search. O(log n)
 */

import java.util.*;

class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                "\nTitle: " + title +
                "\nAuthor: " + author;
    }
}

class LibraryLinearSearch {
    public static Book searchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}



class LibraryBinarySearch {
    public static Book searchByTitle(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle));
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Mahabharata", "Valmiki"),
            new Book(2, "Ramayana", "Arjuna"),
            new Book(3, "1984", "Dev"),
            new Book(4, "Ethereum", "Vitalik Buterin")
        };

        // Linear Search
        System.out.println("Linear Search:");
        Book foundBook = LibraryLinearSearch.searchByTitle(books, "1984");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found.");
        }

        // Binary Search
        System.out.println("\nBinary Search:");
        foundBook = LibraryBinarySearch.searchByTitle(books, "1984");
        if (foundBook != null) {
            System.out.println(foundBook);
        } else {
            System.out.println("Book not found.");
        }
    }
}