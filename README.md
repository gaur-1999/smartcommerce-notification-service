# SmartCommerce Notification Service

Microservices-based e-commerce backend — Event-driven notification service using Apache Kafka.

## Tech Stack
- Java 17
- Spring Boot 4.x
- Apache Kafka
- Docker
- Lombok

## Features
- Kafka Consumer listening on order-placed-topic
- Real-time order notification processing
- Email/SMS simulation on order placement
- Automatic retry on failure

## Kafka Integration
- **Topic:** order-placed-topic
- **Group ID:** notification-group
- **Trigger:** Fires on every new order from Order Service
- **Action:** Processes OrderPlacedEvent and sends notification

## Notification Flow
Order Service → Kafka Topic → Notification Service → Email/SMS


## Sample Notification
Order ID    : 1
Customer    : user@example.com
Product     : iPhone 15 Pro
Quantity    : 2
Total Price : Rs. 1999.98
Status      : PENDING
EMAIL SENT to: user@example.com
SMS SENT successfully!

## Setup

1. Clone the repo
2. Start Kafka using docker-compose
3. Copy `application.properties.example` to `application.properties`
4. Run the application — Port 8084

## Related Services
- [User Service](https://github.com/gaur-1999/smartcommerce-user-service)
- [Product Service](https://github.com/gaur-1999/smartcommerce-product-service)
- [Order Service](https://github.com/gaur-1999/smartcommerce-order-service)
