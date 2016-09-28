package spring.rest.jsonview.ArguementResolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import spring.rest.jsonview.User;

//http://geekabyte.blogspot.com/2014/08/how-to-inject-objects-into-spring-mvc.html
// Resolving controller method's User argument

public class CustomUserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if(parameter.getMethod().getName().equals("testCustomArgumentResolver")) {
            return parameter.getParameterType().equals(User.class);
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory)
            throws Exception {

        User user = new User();
        user.setId(1L);
        user.setFirstname("Tushar");
        user.setLastname("Chokshi");
        user.setEmail("tushar@abc.com");
        user.setCountry("USA");
        return user;
    }
}
