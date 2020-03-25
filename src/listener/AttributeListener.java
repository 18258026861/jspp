package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletRequestAttributeListener, HttpSessionAttributeListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();//获得值
        System.out.println("ServletContext 新增 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value = scae.getValue();//获得值
        System.out.println("ServletContext 移除 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        Object value1 = scae.getValue();
        Object value = scae.getServletContext().getAttribute(name);//获得值
        System.out.println("ServletContext 替换 属性名:"+ name+"属性值："+value1+"为新的属性值："+value);
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();//获得值
        System.out.println("ServletRequest 新增 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();//获得值
        System.out.println("ServletRequest 移除 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value1 = srae.getValue();
        Object value = srae .getServletRequest().getAttribute(name);//获得替换后的值
        System.out.println("ServletRequest 替换 属性名:"+ name+"属性值："+value1+"为新的属性值："+value);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value = se.getValue();//获得值
        System.out.println("Session 新增 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se .getName();
        Object value = se.getValue();//获得值
        System.out.println("Session 移除 属性名:"+ name+"属性值："+value);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String name = se.getName();
        Object value1 = se.getValue();
        Object value = se.getSession().getAttribute(name);//获得值
        System.out.println("Session 替换 属性名:"+ name+"属性值："+value1+"为新的属性值："+value);
    }
}
