package filter;

import javax.servlet.*;
import java.io.IOException;

//想将一个普通的java类变成一个具有特定功能的类。要么继承父类，要么继承接口，要么添加注解
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("拦截请求");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截请求");
        chain.doFilter(request,response);
        System.out.println("拦截响应");
    }

    @Override
    public void destroy() {
        System.out.println("拦截请求");
    }
}
