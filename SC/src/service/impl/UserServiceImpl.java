package service.impl;

import dao.UserDAO;
import bean.User;
import service.UserService;

/**
 * @author shkstart
 * @create 2023--17-22:08
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        User user = userDAO.getUser(uname, pwd);
        return user;
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        User user = userDAO.getUser(uname);
        return user;
    }


}
