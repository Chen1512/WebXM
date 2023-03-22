package service;

import bean.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-14:24
 */
public interface UserBasicService {
    //登录验证
    UserBasic login(String loginid, String pwd);
    //获取好友列表
    List<UserBasic> getFriendList(UserBasic userBasic);
    //根据id获取指定用户的信息
    UserBasic getUserBasicByid(Integer id);

}
