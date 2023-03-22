package CL.servlet1;


import CL.Bean.Fruit;
import CL.DAO.FruitDAO;
import CL.DAO.FruitDAOImpl;
import CL.Servlet.ViewBaseServlet;
import CL.Tools.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "add",urlPatterns = "/add.do")
public class AddServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String fname = request.getParameter("fname");
        Double price = Double.parseDouble(request.getParameter("price")) ;
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");

        Fruit fruit = new Fruit(0,fname , price , fcount , remark ) ;
        Connection conn = JDBC.getConnection();
        fruitDAO.addFruit(conn,fruit);

        response.sendRedirect("index");

    }

}
