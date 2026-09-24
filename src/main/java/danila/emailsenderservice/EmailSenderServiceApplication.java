package danila.emailsenderservice;

import danila.emailsenderservice.email.EmailSenderService;
import danila.emailsenderservice.kafka.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class EmailSenderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSenderServiceApplication.class, args);
    }

}
