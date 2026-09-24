package danila.emailsenderservice.kafka.consumer;

import danila.emailsenderservice.email.EmailSenderService;
import danila.emailsenderservice.kafka.message.EmailMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulerConsumer {
    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = "${kafka.topics.sending-email}",
            properties = "spring.json.value.default.type=danila.emailsenderservice.kafka.message.EmailMessage",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(EmailMessage emailMessage) {
        emailSenderService.send(emailMessage);
    }
}
