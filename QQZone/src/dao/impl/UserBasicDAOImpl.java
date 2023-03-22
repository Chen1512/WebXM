package dao.impl;

import dao.UserBasicDAO;
import bean.UserBasic;
import myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author shkstart
 * @create 2023--12-0:16
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {
    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.GetBean("SELECT * FROM t_user_basic WHERE loginId=? AND pwd=?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        return super.GetBeanList("SELECT fid as id FROM t_friend WHERE uid=?",userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer id) {
        return super.GetBean("SELECT * FROM t_user_basic WHERE id=?",id);
    }
}
