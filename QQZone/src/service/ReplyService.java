package service;

import bean.Reply;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--13-17:51
 */
public interface ReplyService {
    //根据topic的id获取所有的回复
    List<Reply> getReplyListByTopicId(Integer topicId);
    //更具replyID获取回复
    Reply getReplyById(Integer id);
    //添加回复
    void addReply(Reply reply);
    //删除指定回复
    void delReply(Integer replyId);

}
