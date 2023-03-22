package dao;

import bean.HostReply;

/**
 * @author shkstart
 * @create 2023--11-22:41
 */
public interface HostReplyDAO {
    //根据replyId查询关联的HostReply实体
    HostReply getHostReplyByReplyId(Integer replyId);
    //添加主人回复
    void addHostReply(HostReply hostReply);
    //删除主人回复
    void delHostReply(Integer id);
}
