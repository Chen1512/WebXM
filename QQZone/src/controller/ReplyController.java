package controller;

import bean.Reply;
import bean.Topic;
import bean.UserBasic;
import service.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shkstart
 * @create 2023--14-22:03
 */
public class ReplyController {
    private ReplyService replyService;

    public String addReply(String content, Integer topicId, HttpSession session) {
        UserBasic authoro = (UserBasic) session.getAttribute("userBasic");
        Reply reply = new Reply(content, LocalDateTime.now(), authoro, new Topic(topicId));
        replyService.addReply(reply);
        return "redirect:topic.do?operate=topicDetail&topicid=" + topicId;
    }

    public String delReply(Integer replyId,Integer topicId) {
        replyService.delReply(replyId);
        return "redirect:topic.do?operate=topicDetail&topicid=" + topicId;
    }
}

