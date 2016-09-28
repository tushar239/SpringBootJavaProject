package spring.rest.jsonview.ResponseBodyAdvices;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;
import spring.rest.jsonview.EligibleForJsonView;
import spring.rest.jsonview.View;

/*
http://viralpatel.net/blogs/spring-mvc-exception-handling-controlleradvice-annotation/
http://www.jayway.com/2013/02/03/improve-your-spring-rest-api-part-iii/
http://www.javacodegeeks.com/2013/11/controlleradvice-improvements-in-spring-4.html

@ControllerAdvice --- This annotation is used to define @ExceptionHandler, @InitBinder, and @ModelAttribute methods that apply to all @RequestMapping methods.
It can also be used for custom ResponseBodyAdvice

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public String exception(Exception e) {

        return "error";
    }
}
Thus if we define our @ExceptionHandler annotation on method in @ControllerAdvice class, it will be applied to all the controllers.

*/


// ResponseBodyAdvice is called right before response body is written to response.
// Look at RequestMappingHandlerAdapter's afterPropertiesSet(). That is where beans with @ControllerAdvice annotation are set.

@ControllerAdvice
public class CustomResponseBodyJsonViewAdvicer extends AbstractMappingJacksonResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        //return (super.supports(returnType, converterType) && returnType.getMethodAnnotation(EligibleForJsonView.class) != null);
        final EligibleForJsonView eligibleForJsonView = AnnotationUtils.findAnnotation(returnType.getMethod(), EligibleForJsonView.class);
        if(eligibleForJsonView != null) {
            return true;
        }
        return false;
    }
    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType,
                                           MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {

        EligibleForJsonView annotation = returnType.getMethodAnnotation(EligibleForJsonView.class);
        //Class<?>[] classes = annotation.value();
        Class cls = View.Summary.class;
/*
        if (classes.length != 1) {
            throw new IllegalArgumentException(
                    "@JsonView only supported for response body advice with exactly 1 class argument: " + returnType);
        }
*/
        bodyContainer.setSerializationView(cls);
    }

}
