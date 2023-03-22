package test;


import bean.UserBasic;
import myssm.basedao.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author shkstart
 * @create 2023--10-14:03
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = ConnUtil.getConn();
        System.out.println(conn);
        Object a=null;
        Integer b= (Integer) a;
        System.out.println(b);
        UserBasic u= (UserBasic) a;
        System.out.println(u);

    }
}
