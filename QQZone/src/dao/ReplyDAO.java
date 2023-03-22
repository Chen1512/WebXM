package dao;

import bean.Reply;
import bean.Topic;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--11-21:57
 */
public interface ReplyDAO {
    //获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);
    //根据replyId获取回复
    Reply getReply(Integer id);
    //添加回复
    int addReply(Reply reply);
    //删除回复
    int delReply(Integer id);
}
