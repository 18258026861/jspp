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
import java.io.IOException;
import java.io.PrintWriter;

public class updateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String logname = request.getParameter("logname");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        /*String name = req.getParameter("name");
        String tel = req.getParameter("tel");*/

        Register register = new Register(logname,password,name,tel);
        IRegisterDAO registerDAO = new RegisterDAOImp();
        IRegisterService registerServiceImp = new RegisterServiceImp();
        System.out.println(logname);

            boolean result = registerDAO.update(register);
            if(result){
                request.setAttribute("message","修改成功");
                //req.setAttribute("logname",register.getLogname());
                request.getRequestDispatcher("showallServlet").forward(request,response);
            }else
                out.println("change fail");
    }

    @Override
    protected void doGet(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        doPost(requset, response);
    }
}
