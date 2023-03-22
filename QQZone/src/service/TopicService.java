package service;

import bean.Topic;
import bean.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-14:35
 */
public interface TopicService {
    //获取特定用户日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //根据id获取指定topic的信息
    Topic getTopicById(Integer id);
    //根据id删除指定topic信息
    void delTopic(Integer id);
    //添加topic信息
    void addTopic(Topic topic);
}
