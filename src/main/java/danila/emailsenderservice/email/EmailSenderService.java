package danila.emailsenderservice.email;

import danila.emailsenderservice.kafka.message.EmailMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailSenderService {
    private final String fromEmail;
    private final JavaMailSender mailSender;

    public EmailSenderService(
            @Value("${mail.from}")
            String fromEmail,
            JavaMailSender mailSender) {
        this.fromEmail = fromEmail;
        this.mailSender = mailSender;
    }

    public void send(EmailMessage kafkaMessage) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(fromEmail);
            mailMessage.setTo(kafkaMessage.email());
            mailMessage.setSubject(kafkaMessage.headline());
            mailMessage.setText(kafkaMessage.textContent());
            mailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("Failed to send mail letter ", e);
            throw e;
        }
    }
}
