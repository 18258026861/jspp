package service.Imp;

import DAO.IRegisterDAO;
import DAO.Imp.RegisterDAOImp;
import entity.Register;
import service.IRegisterService;

//逻辑业务层,对DAO进行组装
public class RegisterServiceImp implements IRegisterService {
    IRegisterDAO registerDAO = new RegisterDAOImp();

    public boolean add(Register register)  {
        if(!registerDAO.isExist(register.getLogname())){
            registerDAO.add(register);
            return true;
        }else{
            System.out.println("logname is exist");
            return false;
        }
    }
    public boolean isexist(String logname)  {
        boolean result = registerDAO.isExist(logname);
        return result;
    }
    public boolean delete(String logname)  {
        if(isexist(logname)){
            registerDAO.delete(logname);
            return true;
        }else{
            System.out.println("不存在该账号");
            return false;
        }
    }


}
