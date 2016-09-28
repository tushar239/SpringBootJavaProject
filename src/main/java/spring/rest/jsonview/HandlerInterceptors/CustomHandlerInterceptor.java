package spring.rest.jsonview.HandlerInterceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://www.mkyong.com/spring-mvc/spring-mvc-handler-interceptors-example/
// HandlerInterceptor is called before and after Handler's handle() method is called by DispatcherServlet
// In case of Spring MVC, it calls a handler named RequestMappingHandlerAdapter, which is responsible for calling a controller's method

public class CustomHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("Inside CustomHandlerInterceptor:"+ handler.getClass().getName());
        return true;
    }

    /**
     * This implementation is empty.
     */
    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
    }

}
