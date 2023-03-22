package CL.servlet1;


import CL.Bean.Fruit;
import CL.DAO.FruitDAO;
import CL.DAO.FruitDAOImpl;
import CL.Servlet.ViewBaseServlet;
import CL.Tools.JDBC;
import CL.Tools.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

//Servlet从3.0版本开始支持注解方式的注册
@WebServlet(name="/index",urlPatterns = "/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        FruitDAO fruitDAO = new FruitDAOImpl();
        Connection conn = JDBC.getConnection();
        HttpSession session = request.getSession() ;
        Integer pageNo = 1 ;

        String oper = request.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper是空的，说明 不是通过表单的查询按钮点击过来的

        String keyword = null ;
        if(StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1 ， keyword应该从请求参数中获取
            pageNo = 1 ;
            keyword = request.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)){
                keyword = "" ;
            }
            session.setAttribute("keyword",keyword);//后面每一次分页都要用
        }else{
            //说明此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时keyword应该从session作用域获取
            String pageNoStr = request.getParameter("pageNo");
            if(StringUtil.isNotEmpty(pageNoStr)){
                pageNo = Integer.parseInt(pageNoStr);
            }//获取最新的页码
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj!=null){//避免第一次进为null
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }
        //重新更新当前页的值
        session.setAttribute("pageNo",pageNo);
        List<Fruit> fruitList = fruitDAO.getFruitList(conn,keyword , pageNo);

        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int fruitCount = fruitDAO.getFruitCount(conn,keyword);
        //总页数
        int pageCount = (fruitCount+5-1)/5 ;
        /*
        总记录条数       总页数
        1               1
        5               1
        6               2
        10              2
        11              3
        fruitCount      (fruitCount+5-1)/5
         */
        session.setAttribute("pageCount",pageCount);

        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index",request,response);
    }
}
