package test;




import myssm.basedao.ConnUtil;

import java.sql.Connection;

/**
 * @author shkstart
 * @create 2023--17-22:18
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = ConnUtil.getConn();
        System.out.println(conn);
        System.out.println(39.95*3);
    }
}
