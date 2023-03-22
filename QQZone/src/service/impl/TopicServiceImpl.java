package service.impl;

import dao.TopicDAO;
import bean.Reply;
import bean.Topic;
import bean.UserBasic;
import service.ReplyService;
import service.TopicService;
import service.UserBasicService;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-14:39
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO;
    private ReplyService replyService;
    private UserBasicService userBasicService;
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        List<Topic> topicList = topicDAO.getTopicList(userBasic);
        for (Topic topic:topicList) {
            topic.setReplyList(replyService.getReplyListByTopicId(topic.getId()));
            topic.setAuthoro(userBasicService.getUserBasicByid(topic.getAuthor()));
        }
        return  topicList;
    }

    @Override
    public Topic getTopicById(Integer topicid) {
        Topic topic = topicDAO.getTopic(topicid);
        List<Reply> replyList = replyService.getReplyListByTopicId(topic.getId());
        topic.setReplyList(replyList);
        topic.setAuthoro(userBasicService.getUserBasicByid(topic.getAuthor()));
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = getTopicById(id);
        if (topic!=null){
            if (topic.getReplyList()!=null){
                List<Reply> replyList = topic.getReplyList();
                for (Reply reply:replyList){
                    replyService.delReply(reply.getId());
                }
            }
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }
}
