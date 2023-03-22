package service.impl;

import dao.ReplyDAO;
import bean.Reply;
import bean.Topic;
import service.HostReplyService;
import service.ReplyService;
import service.UserBasicService;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--13-17:54
 */
public class ReplyServiceImpl implements ReplyService {
    //自己适合调用DAO
    private ReplyDAO replyDAO;
    //调用其它人适合直接调用service而不是DAO
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;
    @Override
    public List<Reply> getReplyListByTopicId(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (Reply reply:replyList){
            reply.setHostReply( hostReplyService.getHostReplyByReplyId(reply.getId()));
            reply.setAuthoro(userBasicService.getUserBasicByid(reply.getAuthor()));
        //    reply.setTopici(topicService.getTopicById(reply.getTopic()));
        }
        return replyList;
    }
    public Reply getReplyById(Integer id){
        Reply reply = replyDAO.getReply(id);
        reply.setHostReply( hostReplyService.getHostReplyByReplyId(reply.getId()));
        //reply.setTopici(topicService.getTopicById(reply.getTopic()));
        reply.setAuthoro(userBasicService.getUserBasicByid(reply.getAuthor()));
        return reply;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer replyId) {
        Reply reply = getReplyById(replyId);
        if (reply!=null) {
            if(reply.getHostReply()!=null){
                hostReplyService.delHostReply(reply.getHostReply().getId());
            }
            replyDAO.delReply(replyId);
        }
    }
}
