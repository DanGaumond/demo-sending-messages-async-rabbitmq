
# Demo Spring Boot application to send and consume messages asynchronously using RabbitMQ

This is a demo project I wrote to send and consume messages asynchronously using RabbitMQ. This project contains a POST Rest endpoint to send JSON data for an Order, which will be converted and sent to a RabbitMQ message queue. An active JMSListener will consume messages from this message queue and will output the consumed message content in the console.

Here are the steps required to get this project running.

---

## 1. Download and Install RabbitMQ

For the project to work, you need to have a running instance of an RabbitMQ broker.

RabbitMQ can be downloaded at: https://www.rabbitmq.com/download.html

See the official RabbitMQ documentation for the latest instructions for running RabbitMQ.

The exchange, queue name and routing key binding must be configured before in RabbitMQ for this application to work.

---

## 2. Configure the application

To configure the application, open the application.properties file under the src/main/java/resources/ folder.

Here are the important keys to configure:

**Port on which the application will run**

`server.port=8080`

**Host of the RabbitMQ broker**

`spring.rabbitmq.host=localhost`

**Port of the RabbitMQ broker** (5672 is default)

`spring.rabbitmq.port=5672`

**Username to access the broker** (guest is default)

`spring.rabbitmq.username=guest`

**Password to access the broker** (guest is default)

`spring.rabbitmq.password=guest`

### *Note that for the following two properties, the exchange, queue name and routing key binding must be configured in the RabbitMQ configuration.*

**Exchange name**

`spring.rabbitmq.template.exchange=amq.direct`

**Queue name**

`spring.rabbitmq.template.routing-key=demo.order.queue`

---

## 3. Run the application

To run the application, open a command prompt, navigate to the root directory of the project and run the following command to start it using the Maven wrapper.

`mvnw spring-boot:run`

---

## 4. Sending a message to the broker

The application exposes a REST endpoint to post JSON data representing an Order. You can use Postman or CURL to send the JSON as a POST body to the following URL.

The 8080 port can be overridden by modifying the `server.port=8080` key in application.properties.

http://localhost:8080/api/orders

>{ "orderDate": "1655908367000", "invoiceNumber" : "A32zX44", "total": 31.80  }

Upon posting the JSON body to the exposed endpoint, a message will be sent to the RabbitMQ message broker. 
You should then see the message body being output in the terminal window after the message is consumed from the queue.
