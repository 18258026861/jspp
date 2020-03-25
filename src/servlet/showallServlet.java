package servlet;

import DAO.IRegisterDAO;
import DAO.Imp.RegisterDAOImp;
import entity.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class showallServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logname =  (String)session.getAttribute("logname");



        IRegisterDAO registerDAO = new RegisterDAOImp();
        Register register = new Register(registerDAO.showall(logname).getLogname(),registerDAO.showall(logname).getPassword(),registerDAO.showall(logname).getName(),registerDAO.showall(logname).getTel()); ;//调用显示方法
        request.setAttribute("register",register);
        request.getRequestDispatcher("show.jsp").forward(request,response);//跳转


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
