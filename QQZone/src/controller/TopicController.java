package controller;

import bean.Reply;
import bean.Topic;
import bean.UserBasic;
import service.ReplyService;
import service.TopicService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--13-16:51
 */
public class TopicController {
    private TopicService topicService=null;
    public String topicDetail(Integer topicid, HttpSession session){
        Topic topic = topicService.getTopicById(topicid);
        session.setAttribute("topic",topic);
        return "frames/detail";
    }
    public String delTopic(Integer topicId){
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }
    public String getTopicList(HttpSession session){
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        List<Topic> topicList = topicService.getTopicList(userBasic);
        userBasic.setTopicList(topicList);
        session.setAttribute("friend",userBasic);
        return "frames/main";
    }
    public String addTopic(String title,String content,HttpSession session){
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        Topic topic = new Topic(title, content, LocalDateTime.now(), userBasic);
        topicService.addTopic(topic);
        return "redirect:topic.do?operate=getTopicList";
    }
}
