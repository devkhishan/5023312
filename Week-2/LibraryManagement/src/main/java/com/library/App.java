package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookRepository bookRepository = context.getBean(BookRepository.class);
        BookService bookService = (BookService) context.getBean("bookService");
        BookService bookServiceSetter = (BookService) context.getBean("bookServiceSetter");

        bookService.check();
        System.out.println();
        bookServiceSetter.check();


    }
}
