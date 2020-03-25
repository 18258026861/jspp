package entity;

public class Register {
    String logname ;
    String name;
    String tel;
    String password;
    public Register(){

    }
    public Register(String logname,String password){
        this.logname = logname;
        this.password = password;
    }
    public Register(String logname,String password,String name,String tel){
        this.logname = logname;
        this.password = password;
        this.name = name;
        this.tel = tel;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
