package controller;

import bean.Book;
import service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--17-23:21
 */
public class BookController {
    private BookService bookService;
    public String index( HttpSession session){
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList",bookList);
        return "index";

    }
}
