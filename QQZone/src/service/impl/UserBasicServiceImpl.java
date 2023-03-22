package service.impl;

import dao.UserBasicDAO;
import bean.UserBasic;
import service.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-14:26
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO=null;
    //private TopicService topicService;
    @Override
    public UserBasic login(String loginId, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList=new ArrayList<>(userBasicList.size());
        for (int i = 0; i < userBasicList.size(); i++) {
            UserBasic friend = userBasicList.get(i);
            friend = userBasicDAO.getUserBasicById(friend.getId());
            //friend.setTopicList(topicService.getTopicList(friend));
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicByid(Integer id) {
        UserBasic userBasic = userBasicDAO.getUserBasicById(id);
        //userBasic.setTopicList(topicService.getTopicList(userBasic));
        return userBasic;
    }
}
