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
import java.sql.SQLException;

public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String logname = req.getParameter("logname");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String tel = req.getParameter("tel");
        Register register = new Register(logname,password,name,tel);
        IRegisterDAO registerDAO = new RegisterDAOImp();
        IRegisterService registerServiceImp = new RegisterServiceImp();


        boolean result = false;
        try {
            result = registerServiceImp.delete(register.getLogname());
            if(result){
                System.out.println("删除成功");
            }
            System.out.println("删除失败");
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
