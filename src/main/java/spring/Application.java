package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*

This project is an example of how to covert simple java project (jar) into web application(war).

http://spring.io/guides/gs/convert-jar-to-war-maven/

mvn install
java -jar target/SpringBootJavaProject-0.0.1-SNAPSHOT.war

*/

@EnableAutoConfiguration
@Configuration
@Import(value = {WebMvcConfiguration.class})
@ComponentScan
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }



}