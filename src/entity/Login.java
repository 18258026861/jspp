package entity;

public class Login {
    //封装数据的javaBean，对应数据库里的表
    private String logname;
    private String password;


    public  Login(){
    }
    public Login(String logname,String password){
        this.logname = logname;
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }
}
