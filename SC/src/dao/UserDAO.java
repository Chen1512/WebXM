package dao;

import bean.User;

/**
 * @author shkstart
 * @create 2023--17-21:32
 */
public interface UserDAO {
    User getUser(String uname, String pwd);
    void addUser(User user);
    User getUser(String uname);
}
