package bean;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author shkstart
 * @create 2023--10-23:26
 */
public class HostReply {
    private Integer id;
    private String content;
    private LocalDateTime hostReplyDate;
    private Integer author;
    private UserBasic authoro;
    private Integer reply;
    private Reply replyl;

    public HostReply() {
    }

    public HostReply(Integer id) {
        this.id = id;
    }

    public HostReply(String content, LocalDateTime hostReplyDate, UserBasic authoro, Reply replyl) {
        this.content = content;
        this.hostReplyDate = hostReplyDate;
        this.authoro = authoro;
        this.replyl = replyl;
    }

    @Override
    public String toString() {
        return "HostReply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", hostReplyDate=" + hostReplyDate +
                ", author=" + author +
                ", reply=" + reply +
                '}';
    }

    public UserBasic getAuthoro() {
        return authoro;
    }

    public void setAuthoro(UserBasic authoro) {
        this.authoro = authoro;
    }

    public Reply getReplyl() {
        return replyl;
    }

    public void setReplyl(Reply replyl) {
        this.replyl = replyl;
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

    public LocalDateTime getHostReplyDate() {
        return hostReplyDate;
    }

    public void setHostReplyDate(LocalDateTime hostReplyDate) {
        this.hostReplyDate = hostReplyDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getReply() {
        return reply;
    }

    public void setReply(Integer reply) {
        this.reply = reply;
    }
}
