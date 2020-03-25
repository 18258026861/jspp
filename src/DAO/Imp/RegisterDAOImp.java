package DAO.Imp;

import DAO.IRegisterDAO;
import entity.Register;
import util.DButil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAOImp implements IRegisterDAO {
    public static String sql = null;
    public static String logname = null;
    public static String password = null;
    public static String name = null;
    public static String tel = null;
    public static PreparedStatement preparedStatement =null;
    public static ResultSet resultSet  =null;


    //查询该账号
    public  boolean querylogname(String logname)  {
        boolean flag = false;

            sql = "select * from register where logname = ?";
            Object[] obj = {logname};
        resultSet = DButil.executeQuery(sql, obj);
        try {
            if(resultSet.next()) {
                String logname1 = resultSet.getString(1);
                if (logname1.equals(logname)) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DButil.closeAll(resultSet,preparedStatement, DButil.connection);
            return flag;
        }
    }

    //是否存在该账号，true存在，false不存在
    public  boolean isExist(String logname)  {
        return querylogname(logname);
    }


    public  boolean add(Register register)  {

       sql = "insert into register values(?,?,?,?)";
       Object[] obj = {register.getLogname(), register.getPassword(), register.getName(), register.getTel()};
       return DButil.executeUpdate(sql,obj);
    }


    public  boolean delete(String logname)  {
        sql = "delete from register where logname = ?";
        Object[] obj = {logname};
        return DButil.executeUpdate(sql,obj);
    }

    public  boolean update(Register register)  {
        sql = "update register set password = ? , name =? , tel =? where logname = ?";
        Object[] obj = {register.getPassword(),register.getName(),register.getTel(),register.getLogname()};
        return DButil.executeUpdate(sql,obj);

    }


    public  String login(String logname)  {
        try{
        sql = "select * from register where logname = ?";
        Object[] objects ={logname};
        resultSet = DButil.executeQuery(sql,objects);
        if(resultSet.next()) {
            this.password = resultSet.getString(2);
        }
    }catch (SQLException e){
        e.printStackTrace();
    }catch (Exception e){
        e.printStackTrace();
    }finally {
            DButil.closeAll(resultSet,preparedStatement, DButil.connection);
        }
        return  password;
    }

    public Register showall(String logname)  {
        Register register = new Register();
        sql = "select * from register where logname = ?";
        Object[] objects ={logname};
        resultSet = DButil.executeQuery(sql,objects);
        try {
            if(resultSet.next()){
            register.setLogname(resultSet.getString(1));
            register.setPassword(resultSet.getString(2));
            register.setName(resultSet.getString(3));
            register.setTel(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            DButil.closeAll(resultSet,preparedStatement, DButil.connection);
            System.out.println(register.getPassword());
        }
        return register;
    }
}
