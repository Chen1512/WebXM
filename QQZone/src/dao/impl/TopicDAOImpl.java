package dao.impl;

import dao.TopicDAO;
import bean.Topic;
import bean.UserBasic;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-0:33
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {
    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.GetBeanList("SELECT * FROM t_topic WHERE author=?",userBasic.getId());
    }

    @Override
    public int addTopic(Topic topic) {
        return super.Update("INSERT INTO t_topic VALUES(0,?,?,?,?);",topic.getTitle(),topic.getContent(),topic.getTopicDate(),topic.getAuthoro().getId());
    }

    @Override
    public int delTopic(Topic topic) {
        return super.Update("DELETE FROM t_topic WHERE id=?",topic.getId());
    }

    @Override
    public Topic getTopic(Integer id) {
        return super.GetBean("SELECT * FROM t_topic WHERE id=?",id);
    }
}
