package servlet;

import DAO.IRegisterDAO;
import DAO.Imp.RegisterDAOImp;
import entity.Register;
import service.IRegisterService;
import service.Imp.RegisterServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IRegisterService registerServiceImp = new RegisterServiceImp();
        IRegisterDAO registerDAO = new RegisterDAOImp();
        /*req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();*/
        HttpSession session = req.getSession();

        String logname =  req.getParameter("logname");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        String password = req.getParameter("password");
        Register register = new Register(logname,password,name,tel);


        try {
            //注册
            boolean result = registerServiceImp.add(register);
            if(result){
                session.setAttribute("logname",logname);
                req.setAttribute("message","注册成功");
                req.getRequestDispatcher("success.jsp").forward(req,resp);

            }else{
                req.setAttribute("message","注册失败");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
