package service;

import bean.HostReply;
import bean.Reply;

/**
 * @author shkstart
 * @create 2023--13-21:18
 */
public interface HostReplyService {
    //根据replyId获取主人回复
    HostReply getHostReplyByReplyId(Integer replyId);
    //添加主人回复
    void addHostReply(HostReply hostReply);
    //删除主人回复
    void delHostReply(Integer id);
}
