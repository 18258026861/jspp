package DAO;
import entity.Login;

import java.sql.*;

public class loginDAO {
    //封装业务逻辑的javaBean
    public int login(Login login) throws SQLException {
   // String logname = request.getParameter("logname");//request是jsp内置方法，java能不可使用
   // String password = request.getParameter("password");
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    Statement statement = null;
    CallableStatement callableStatement = null;
    String sql;// 用于后面对应不同的sql语句
    int updateResult = -1;//执行语句的结果，不成功为-1
    ResultSet resultSet;

    connection = null; // 创建一个connection
            try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "javase.jdbc:mysql://localhost:3306/mobileshop?" +
                "user=root&password=yzy665128&characterEncoding=gb2312";
        //建立连接
        connection = DriverManager.getConnection(url);
        sql = "select count(*) from user where logname = ? and password = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,login.getLogname());
        preparedStatement.setString(2,login.getPassword());
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            updateResult = resultSet.getInt(1);
            /*if(updateResult>0){
                System.out.println("登陆成功");
                //request.getRequestDispatcher("success.jsp").forward(request,response);
            }
            else{
                //System.out.println("登录失败");
                //request.setAttribute(bean,"登录失败");
                //response.sendRedirect("login.jsp");
            }*/
        }

    } catch (ClassNotFoundException e) {
        System.out.println("JDBC Driver not found");
        e.printStackTrace();
                updateResult = 0;
    } catch (SQLException e) {
        System.out.println("SQL 执行错误");
        e.printStackTrace();
                updateResult = 0;
    } catch (Exception e) {
        e.printStackTrace();
              updateResult = 0;
    }finally {
        preparedStatement.close();
        connection.close();
                return updateResult;
    }

    }
}
