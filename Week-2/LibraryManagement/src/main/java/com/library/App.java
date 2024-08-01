package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.awt.print.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository bookRepository = context.getBean(BookRepository.class);
        BookService bookService = context.getBean(BookService.class);

        System.out.println(bookRepository.isBookAvailable());
        bookService.run();


    }
}
