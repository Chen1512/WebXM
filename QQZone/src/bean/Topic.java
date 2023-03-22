package bean;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--10-22:47
 */
public class Topic {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime topicDate;
    private Integer author;
    private UserBasic authoro;

    private List<Reply> replyList;


    public Topic() {
    }

    public Topic(Integer id) {
        this.id = id;
    }

    public Topic(String title, String content, LocalDateTime topicDate, UserBasic authoro) {
        this.title = title;
        this.content = content;
        this.topicDate = topicDate;
        this.authoro = authoro;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", topicDate=" + topicDate +
                ", author=" + author +
                ", authoro=" + authoro +
                ", replyList=" + replyList +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTopicDate() {
        return topicDate;
    }

    public void setTopicDate(LocalDateTime topicDate) {
        this.topicDate = topicDate;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public UserBasic getAuthoro() {
        return authoro;
    }

    public void setAuthoro(UserBasic authoro) {
        this.authoro = authoro;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }
}
