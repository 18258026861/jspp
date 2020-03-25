package service;

import DAO.IRegisterDAO;
import DAO.Imp.RegisterDAOImp;
import entity.Register;

import java.sql.SQLException;

public interface IRegisterService {
    IRegisterDAO registerDAO = new RegisterDAOImp();

    public boolean add(Register register) throws SQLException, ClassNotFoundException;
    public boolean isexist(String logname) throws SQLException, ClassNotFoundException;
    public boolean delete(String logname) throws SQLException, ClassNotFoundException;
}
