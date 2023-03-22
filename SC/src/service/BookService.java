package service;

import bean.Book;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--17-22:54
 */
public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
