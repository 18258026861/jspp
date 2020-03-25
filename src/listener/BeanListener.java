package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BeanListener  implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("绑定Bean对象：就是将Bean对象增加到session域当中");
        System.out.println("绑定对象："+this+",sessionID:" + event.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("解绑Bean对象：就是将Bean对象在session域中");
        System.out.println("绑定对象："+this+",sessionID:" + event.getSession().getId());
    }
}
