package com.sageit.message_to_kafka.controller; // This is the address of our traffic cop.

import com.sageit.message_to_kafka.KafkaMessage; // We need to know about the messages coming in.
import org.springframework.beans.factory.annotation.Autowired; // Spring will help us connect with the worker.
import org.springframework.http.HttpStatus; // For sending back success responses.
import org.springframework.http.ResponseEntity; // Represents the entire HTTP response.
import org.springframework.web.bind.annotation.*;
import com.sageit.message_to_kafka.service.KafkaProducerService;

@RestController // This makes it a controller that returns data directly in the response.
@RequestMapping("/message-to-kafka/topics") // This is the URL where we'll receive POST requests.
public class MessageController {

    @Autowired // Spring, please connect me to the KafkaProducerService.
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/msg") // This tells Spring that this method handles POST requests to the URL defined above.
    public ResponseEntity<String> publishMessage(@RequestBody KafkaMessage message) { // This method takes the JSON data as a KafkaMessage.
        kafkaProducerService.sendMessage(message); // Tell the postal worker to send the message.
        return ResponseEntity.status(HttpStatus.OK).body("Message sent sucessfully"); // Send back a success response.
    }

}
