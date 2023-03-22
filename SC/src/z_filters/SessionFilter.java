package z_filters;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author shkstart
 * @create 2023--20-16:39
 */
//@WebFilter(urlPatterns = {"*.do","*.html"},
//                initParams = {
//        @WebInitParam(name = "bai",
//                value = "/SC/page.do?operate=page&page=user/login,/SC/user.do?null")
//})
public class SessionFilter implements Filter {
    List<String> baiList=null;
    @Override
    public void init(FilterConfig config) throws ServletException {
        String bai = config.getInitParameter("bai");
        String[] baiArr = bai.split(",");
        baiList = Arrays.asList(baiArr);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        System.out.println(request.getRequestURI());
        System.out.println(request.getQueryString());

        String uri=request.getRequestURI();
        String s = request.getQueryString();
        String str=uri+"?"+s;

        if (baiList.contains(str)){
            filterChain.doFilter(request,response);
        }else {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("currUser");
            if (user==null){
                response.sendRedirect("page.do?operate=page&page=user/login");
            }else{
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
