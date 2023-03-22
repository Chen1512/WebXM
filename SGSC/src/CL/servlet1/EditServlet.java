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
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name ="/edit" ,urlPatterns = "/edit.do")
public class EditServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws IOException, ServletException {
        String fidStr = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)){
            int fid = Integer.parseInt(fidStr);
            Connection conn = JDBC.getConnection();
            Fruit fruit = fruitDAO.getFruitByFid(conn,fid);
            request.setAttribute("fruit",fruit);
            super.processTemplate("edit",request,response);
        }
    }
}
