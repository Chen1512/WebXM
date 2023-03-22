package dao;

import bean.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--11-16:10
 */
public interface UserBasicDAO {
    //根据账号和密码获取特定用户信息
    UserBasic getUserBasic(String loginId, String pwd);

    //获取指定用户的所有好友列表
    List<UserBasic> getUserBasicList(UserBasic userBasic);

    //根据id查询UserBasic的信息
    UserBasic getUserBasicById(Integer id);
}
