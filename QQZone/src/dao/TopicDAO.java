package dao;

import bean.Topic;
import bean.UserBasic;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--11-20:24
 */
public interface TopicDAO {
    //获取指定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);
    //添加日志
    int addTopic(Topic topic);
    //删除日志
    int delTopic(Topic topic);
    //获取特定日志信息
    Topic getTopic(Integer id);


}
