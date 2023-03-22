package service.impl;

import bean.Book;
import dao.BookDAO;
import service.BookService;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--17-23:02
 */
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookDAO.getBookList();
        return bookList;
    }

    @Override
    public Book getBook(Integer id) {
        Book book = bookDAO.getBookById(id);
        return book;
    }
}
