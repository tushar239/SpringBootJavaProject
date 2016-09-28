package spring.boot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 Try - http://localhost:8080/hello/index
 http://localhost:8080/hello/index1
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value="/index1", method=RequestMethod.GET)
    public String index1() {
        return "index1";
    }
}