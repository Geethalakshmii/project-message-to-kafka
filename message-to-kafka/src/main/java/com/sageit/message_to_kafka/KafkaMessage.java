package com.sageit.message_to_kafka;

public class    KafkaMessage {
    private String message;

    public KafkaMessage() {
    }

    public KafkaMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "KafkaMessage{message='" + message + "'}";
    }
}
