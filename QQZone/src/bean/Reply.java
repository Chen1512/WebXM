package bean;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shkstart
 * @create 2023--10-23:23
 */
public class Reply {
    private Integer id;
    private String content;
    private LocalDateTime replyDate;
    private Integer author;
    private UserBasic authoro;
    private Integer topic;
    private Topic topici;
    private HostReply hostReply;

    public Reply(Integer id) {
        this.id = id;
    }

    public Reply() {
    }

    public Reply(String content, LocalDateTime replyDate, UserBasic authoro, Topic topici) {
        this.content = content;
        this.replyDate = replyDate;
        this.authoro = authoro;
        this.topici = topici;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", replyDate=" + replyDate +
                ", author=" + author +
                ", topic=" + topic +
                ", hostReply=" + hostReply +
                '}';
    }

    public UserBasic getAuthoro() {
        return authoro;
    }

    public void setAuthoro(UserBasic authoro) {
        this.authoro = authoro;
    }

    public Topic getTopici() {
        return topici;
    }

    public void setTopici(Topic topici) {
        this.topici = topici;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public HostReply getHostReply() {
        return hostReply;
    }

    public void setHostReply(HostReply hostReply) {
        this.hostReply = hostReply;
    }
}
