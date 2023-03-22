package dao.impl;

import dao.HostReplyDAO;
import bean.HostReply;
import myssm.basedao.BaseDAO;

/**
 * @author shkstart
 * @create 2023--13-21:22
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply>  implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        HostReply hostReply = super.GetBean("SELECT * FROM t_host_reply WHERE reply=?", replyId);
        return hostReply;
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        int update = super.Update("INSERT INTO t_host_reply VALUES(0,?,?,?,?)", hostReply.getContent(), hostReply.getHostReplyDate(), hostReply.getAuthoro().getId(), hostReply.getReplyl().getId());
    }

    @Override
    public void delHostReply(Integer id) {
        super.Update("DELETE FROM t_host_reply WHERE id=?",id);
    }
}
