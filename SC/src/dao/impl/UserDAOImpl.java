package dao.impl;


import dao.UserDAO;
import bean.User;
import myssm.basedao.BaseDAO;


/**
 * @author shkstart
 * @create 2023--17-21:34
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User getUser(String uname, String pwd) {
        User user = super.load("SELECT * FROM t_user WHERE uname like ? AND pwd like ?", uname, pwd);
        return user;
    }

    @Override
    public void addUser(User user) {
        int i = super.executeUpdate("INSERT INTO t_user VALUES(0,?,?,?,0)", user.getUname(), user.getPwd(), user.getEmail());
    }

    @Override
    public User getUser(String uname) {
        User user = super.load("SELECT * FROM t_user WHERE uname like ?", uname);
        return user;
    }
}
