package servlet;

import DAO.IRegisterDAO;
import DAO.Imp.RegisterDAOImp;
import service.IRegisterService;
import service.Imp.RegisterServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    public static PreparedStatement preparedStatement = null;
    public static Connection connection = null;
    public static Statement statement = null;
    public static CallableStatement callableStatement = null;
    public static String sql;// 用于后面对应不同的sql语句
    public static int updateResult = -1;//执行语句的结果，不成功为-1
    public static ResultSet resultSet;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        HttpSession session = request.getSession();
        /*request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();*/

        String logname = request.getParameter("logname");
        String password = request.getParameter("password");
        IRegisterService registerServiceImp = new RegisterServiceImp();
        IRegisterDAO registerDAO = new RegisterDAOImp();


        try {
            if(registerServiceImp.isexist(logname)) {
                String p = registerDAO.login(logname);
                if (p.equals(password)) {
                    session.setAttribute("logname",logname);//能用request就不用session
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                } else
                   poperror(request,response,"密码错误");
            }
            else
                poperror(request,response,"用户名不存在");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void poperror(HttpServletRequest request, HttpServletResponse response,String message) throws ServletException, IOException {

        request.setAttribute("message", message);          // 设置错误属性
        request.getRequestDispatcher("login.jsp").forward(request, response); //JSP中不能省略
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            doPost(request, response);
        }

    }

