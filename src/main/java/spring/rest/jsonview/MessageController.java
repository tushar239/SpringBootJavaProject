package spring.rest.jsonview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Tushar Chokshi @ 4/29/15.
 */

// https://spring.io/blog/2014/12/02/latest-jackson-integration-improvements-in-spring
// https://github.com/sdeleuze/spring-jackson-demo

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //@JsonView(View.Summary.class)
    @EligibleForJsonView
    @RequestMapping("/all")
    public @ResponseBody List<Message> getAllMessages() {
        return messageService.getAll();
    }

    //@JsonView(View.SummaryWithRecipients.class)
    @EligibleForJsonView
    @RequestMapping("/with-recipients")
    public @ResponseBody List<Message> getAllMessagesWithRecipients() {
        return messageService.getAll();
    }

    @RequestMapping("/{id}")
    public @ResponseBody  Message getMessage(@PathVariable Long id) {
        return messageService.get(id);
    }

    @RequestMapping("/testarguementresolver")
    // If you say @RequestBody User user, then spring will expect you to send it in json/xml format as a part of request body
    // Without any annotation, it will simply act as an arguement of the handler method that can be resolve using custom Argument Resolver
    // Spring has its own Argument Resolvers to resolve arguments annotted with @RequestBody/@ModelAttribute/@PathVariable/@RequestHeader etc.
    // Here I have used CustomUserArgumentResolver
    public @ResponseBody  User testCustomArgumentResolver(/*@RequestBody User user*/ User user) {
        return user;
    }

}