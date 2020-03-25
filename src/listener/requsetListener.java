package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class requsetListener implements ServletRequestListener,ServletContextListener,HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听servletContext,创建"+sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听servletContext，销毁"+sce);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("监听session，销毁"+se);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("监听session，创建"+se);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("监听requset，创建"+sre);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("监听requset，销毁"+sre);
    }
}
