package com.sageit.message_to_kafka.service; // This is the address of our postal worker.

import com.sageit.message_to_kafka.KafkaMessage; // Our worker needs to know what a message looks like.
import org.slf4j.Logger; // For writing notes about what our worker is doing.
import org.slf4j.LoggerFactory; // To get a tool for writing notes.
import org.springframework.beans.factory.annotation.Autowired; // Spring will give our worker some tools.
import org.springframework.kafka.core.KafkaTemplate; // This is Spring's special tool for sending things to Kafka.
import org.springframework.stereotype.Service; // This tells Spring that this is our postal worker.

@Service // This special instruction tells Spring to manage our postal worker.
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class); // Giving our worker a notepad.
    private static final String TOPIC = "Greetings"; // The address of the Kafka mailbox.

    @Autowired // Spring, please give our worker the Kafka sending tool.
    private KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public void sendMessage(KafkaMessage message) { // This is the action our worker performs: sending a message.
        logger.info(String.format("Sending message to %s: %s", TOPIC, message)); // Our worker writes a note: "Sending to [address]: [message]".
        kafkaTemplate.send(TOPIC, message); // Our worker uses the special tool to send the message to the Kafka mailbox.
    }
}
