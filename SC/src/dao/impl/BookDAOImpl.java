package dao.impl;

import bean.Book;

import dao.BookDAO;
import myssm.basedao.BaseDAO;


import java.util.List;

/**
 * @author shkstart
 * @create 2023--17-22:57
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        List<Book> books = super.executeQuery("SELECT * FROM t_book where bookStatus=0");
        return books;
    }

    @Override
    public Book getBookById(Integer id) {
        Book book = super.load("select * from t_book where id=?", id);
        return book;
    }
}
