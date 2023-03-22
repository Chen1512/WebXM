package controller;

import bean.HostReply;
import bean.Reply;
import bean.Topic;
import bean.UserBasic;
import service.HostReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author shkstart
 * @create 2023--15-17:20
 */
public class HostReplyController {
    HostReplyService hostReplyService;
    public String addHostReply(String content, Integer replyId, Integer topicId,HttpSession session){
        UserBasic authoro = (UserBasic) session.getAttribute("userBasic");
        HostReply hostReply = new HostReply(content, LocalDateTime.now(), authoro, new Reply(replyId));
        hostReplyService.addHostReply(hostReply);
        return "redirect:topic.do?operate=topicDetail&topicid="+topicId;



    }
}
