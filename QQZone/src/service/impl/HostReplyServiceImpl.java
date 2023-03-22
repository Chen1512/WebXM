package service.impl;

import dao.HostReplyDAO;
import bean.HostReply;
import service.HostReplyService;

/**
 * @author shkstart
 * @create 2023--13-21:19
 */
public class HostReplyServiceImpl implements HostReplyService {
    private HostReplyDAO hostReplyDAO;
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        HostReply hostReply = hostReplyDAO.getHostReplyByReplyId(replyId);
        return hostReply;
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDAO.addHostReply(hostReply);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
