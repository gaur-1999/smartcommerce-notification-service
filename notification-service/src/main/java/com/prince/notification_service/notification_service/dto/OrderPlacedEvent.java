package com.prince.notification_service.notification_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPlacedEvent {

    private Long orderId;

    private String userEmail;

    private String productName;

    private Integer quantity;

    private Double totalPrice;

    private String status;
}
