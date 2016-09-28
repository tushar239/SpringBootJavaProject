package spring.rest.jsonview;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tushar Chokshi @ 4/29/15.
 */
@Service
public class MessageService {

    public List<Message> getAll() {
        List<Message> messages = new ArrayList<Message>();
        Message message = getMessage();

        messages.add(message);

        return messages;
    }

    private Message getMessage() {
        Message message = new Message();
        message.setId(1L);
        message.setCreated(new Date());
        message.setBody("body");
        message.setTitle("title");
        User author = getUser();
        message.setAuthor(author);

        List<User> recipients = new ArrayList<User>();
        recipients.add(author);
        message.setRecipients(recipients);
        return message;
    }

    private User getUser() {
        User author = new User();
        author.setId(1L);
        author.setAddress("address");
        author.setCity("city");
        author.setCountry("country");
        author.setEmail("email");
        author.setFirstname("Tushar");
        author.setLastname("Chokshi");
        author.setPostalCode("98052");
        return author;
    }

    public Message get(Long id) {
        return getMessage();
    }
}
