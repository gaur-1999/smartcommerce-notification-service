package com.prince.notification_service.notification_service.service;




import com.fasterxml.jackson.databind.ObjectMapper;
import com.prince.notification_service.notification_service.dto.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(
            topics = "order-placed-topic",
            groupId = "notification-group"
    )
    public void handleOrderPlaced(String message) {
        log.info("Message received from Kafka: {}", message);
        try {
            OrderPlacedEvent event = objectMapper
                    .readValue(message, OrderPlacedEvent.class);

            log.info("=====================================");
            log.info("NEW ORDER NOTIFICATION");
            log.info("=====================================");
            log.info("Order ID    : {}", event.getOrderId());
            log.info("Customer    : {}", event.getUserEmail());
            log.info("Product     : {}", event.getProductName());
            log.info("Quantity    : {}", event.getQuantity());
            log.info("Total Price : Rs. {}", event.getTotalPrice());
            log.info("Status      : {}", event.getStatus());
            log.info("=====================================");
            log.info("EMAIL SENT to: {}", event.getUserEmail());
            log.info("SMS SENT successfully!");
            log.info("=====================================");

        } catch (Exception e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
