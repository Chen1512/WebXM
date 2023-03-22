package controller;

import bean.Topic;
import bean.UserBasic;
import service.TopicService;
import service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-15:18
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;
    public String login(String loginId, String pwd, HttpSession session){
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if (userBasic!=null){
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            //userBasic登入者的信息
            session.setAttribute("userBasic",userBasic);
            //当前进入谁的空间
            session.setAttribute("friend",userBasic);
            return "index";
        }else{
            return "login";
        }
    }
    public String friend(Integer id,HttpSession session){
        //根据id获取指定用户信息
        UserBasic currFriend = userBasicService.getUserBasicByid(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend",currFriend);
        return "index";
    }
}
