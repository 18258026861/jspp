package DAO;

import entity.Register;

import java.sql.SQLException;

public interface IRegisterDAO {


    //查询该账号
    public  boolean querylogname(String logname) throws SQLException;

    //是否存在该账号，true存在，false不存在
    public  boolean isExist(String logname)  ;

    public  boolean add(Register register)  ;

    public  boolean delete(String logname) ;

    public  boolean update(Register register) ;

    public  String login(String logname)  ;

    public  Register showall(String lognmae)  ;
}

