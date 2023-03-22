package dao.impl;

import dao.ReplyDAO;
import bean.Reply;
import bean.Topic;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-1:25
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        List<Reply> replyList = super.GetBeanList("SELECT * FROM t_reply WHERE topic=?", topic.getId());
        return replyList;
    }
    public Reply getReply(Integer id) {
        return super.GetBean("SELECT * FROM t_reply WHERE id=?", id);
    }

    @Override
    public int addReply(Reply reply) {
        return super.Update("INSERT INTO t_reply VALUES(0,?,?,?,?)",reply.getContent(),reply.getReplyDate(),reply.getAuthoro().getId(),reply.getTopici().getId());
    }

    @Override


    public int delReply(Integer id) {
        return super.Update("DELETE FROM t_reply WHERE id=?",id);
    }

}
