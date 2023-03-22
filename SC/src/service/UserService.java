package service;

import bean.User;

/**
 * @author shkstart
 * @create 2023--17-22:07
 */
public interface UserService {
    User login(String uname,String pwd);
    void regist(User user);
    User getUser(String uname);
}
