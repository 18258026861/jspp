package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class BeanListener2 implements HttpSessionActivationListener {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //监听时刻：即将钝化之前
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("钝化");
    }
    //监听时刻：刚刚活化时
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("活化");

    }
}
