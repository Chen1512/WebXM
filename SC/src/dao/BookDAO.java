package dao;

import bean.Book;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--17-22:54
 */
public interface BookDAO {
    List<Book> getBookList();
    Book getBookById(Integer id);
}
