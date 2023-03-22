package CL.Servlet;

import CL.Bean.Fruit;
import CL.DAO.FruitDAO;
import CL.DAO.FruitDAOImpl;
import CL.Tools.JDBC;
import CL.Tools.StringUtil;
import CL.service.FruitService;
import CL.service.FruitServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--01-21:53
 */
public class FruitController {
    FruitService fruitService=null;
    //@Override
    //protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //    //设置编码
    //    request.setCharacterEncoding("UTF-8");
    //    String operate = request.getParameter("operate");
    //    if (StringUtil.isEmpty(operate)){
    //        operate="index";
    //    }
    //    switch (operate){
    //        case "index":
    //            index(request,response);
    //            break;
    //        case "add":
    //            add(request,response);
    //            break;
    //        case "del":
    //            del(request,response);
    //            break;
    //        case "edit":
    //            edit(request,response);
    //            break;
    //        case "update":
    //            update(request,response);
    //            break;
    //        default:
    //            throw new RuntimeException("operate值非法!");
    //    }
    //
    //}
    private String update(Integer fid,String fname,Double price,Integer fcount,String remark){
        ////1.设置编码
        //request.setCharacterEncoding("utf-8");
        //
        ////2.获取参数
        //String fidStr = request.getParameter("fid");
        //Integer fid = Integer.parseInt(fidStr);
        //String fname = request.getParameter("fname");
        //String priceStr = request.getParameter("price");
        //Double price = Double.parseDouble(priceStr);
        //String fcountStr = request.getParameter("fcount");
        //Integer fcount = Integer.parseInt(fcountStr);
        //String remark = request.getParameter("remark");

        //3.执行更新
        fruitService.updateFruit(new Fruit(fid,fname, price ,fcount ,remark ));

        //4.资源跳转
        //super.processTemplate("index",request,response);
        //request.getRequestDispatcher("index.html").forward(request,response);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
        //response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }
    private String edit(String fid,HttpServletRequest request ) {
        //String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fid)){
            Integer fidInt = Integer.parseInt(fid);
            Fruit fruit = fruitService.getFruitByFid(fidInt);
            request.setAttribute("fruit",fruit);
            //super.processTemplate("edit",request,response);
            return "edit";

        }
        return "error" ;
    }
    private String del(String fid)throws IOException, ServletException {
        //String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fid)){
            int fidInt = Integer.parseInt(fid);
            fruitService.delFruit(fidInt);

            //super.processTemplate("index",request,response);
            //response.sendRedirect("fruit.do");
            return "redirect:fruit.do";
        }
        return "error" ;
    }
    private String add(String fname,Double price,Integer fcount,String remark)  {
        //request.setCharacterEncoding("UTF-8");

        //String fname = request.getParameter("fname");
        //Double price = Double.parseDouble(request.getParameter("price")) ;
        //Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        //String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;
        fruitService.addFruit(fruit);

        //response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }
    private String index(String oper,String keyword,Integer pageNo,HttpServletRequest request ) {

        HttpSession session = request.getSession() ;

        if (pageNo==null){
            pageNo=1;
        }
        //Integer pageNo = 1 ;

        //String oper = request.getParameter("oper");
        //如果oper!=null 说明 通过表单的查询按钮点击过来的
        //如果oper是空的，说明 不是通过表单的查询按钮点击过来的

        //String keyword = null ;
        if(StringUtil.isNotEmpty(oper) && "search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1 ， keyword应该从请求参数中获取
            pageNo = 1 ;
            //keyword = request.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)){
                keyword = "" ;
            }
            session.setAttribute("keyword",keyword);//后面每一次分页都要用
        }else{
            //说明此处不是点击表单查询发送过来的请求（比如点击下面的上一页下一页或者直接在地址栏输入网址）
            //此时keyword应该从session作用域获取
            //String pageNoStr = request.getParameter("pageNo");
            //if(StringUtil.isNotEmpty(pageNoStr)){
            //    pageNo = Integer.parseInt(pageNoStr);
            //}//获取最新的页码
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj!=null){//避免第一次进为null
                keyword = (String)keywordObj ;
            }else{
                keyword = "" ;
            }
        }
        //重新更新当前页的值
        session.setAttribute("pageNo",pageNo);
        List<Fruit> fruitList = fruitService.getFruitList(keyword , pageNo);

        session.setAttribute("fruitList",fruitList);

        //总记录条数
        int pageCount = fruitService.getPageCount(keyword);
        //总页数
        //int pageCount = (fruitCount+5-1)/5 ;
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
        //super.processTemplate("index",request,response);
        return "index" ;
    }

}
