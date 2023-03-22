package CL.test;

import CL.Tools.JDBC;

import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * @author shkstart
 * @create 2023--26-14:52
 */
public class connTest {
    public static void main(String[] args) {
        a c=new b();
        Method[] methods = c.getClass().getDeclaredMethods();
        for (Method m:methods) {
            System.out.println(m);

        }
        //Connection conn = JDBC.getConnection();
        //System.out.println(conn);
        //connTest connTest = new connTest();
        //connTest.c1();
        //connTest.c2();
    }
    public void c1(){
        System.out.println("123");
        c2();
    }
    public void c2(){
        System.out.println("221");
    }
}
