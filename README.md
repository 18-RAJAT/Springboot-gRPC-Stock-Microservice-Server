# Spring Boot gRPC Stock Trading Microservice

This project is a **Stock Trading Microservice** built using **Spring Boot**, **gRPC**, and **MySQL**.  
It exposes gRPC endpoints for stock trading operations such as fetching stock prices.

---

## Features
- Spring Boot gRPC Server
- MySQL Database Integration (via Spring Data JPA + Hibernate)
- Stock price fetch and trading service
- Tested using **Postman gRPC client**
- Modular structure for easy extension

---

## Tech Stack
- **Java 17+**
- **Spring Boot**
- **gRPC**
- **MySQL**
- **Maven**

---

##  Project Structure
```
stock-trading-server/
 ├── src/main/java/com/example/stock_trading_server
 │    ├── StockTradingServerApplication.java   # Main entry point
 │    ├── service/                             # Service implementation
 │    └── proto/                               # gRPC .proto files
 ├── src/main/resources/
 │    ├── application.properties
 │    └── application.yml
 ├── src/test/java/                            # Unit tests
 ├── pom.xml
```

---

## ️ Database Configuration

Configure your MySQL database in `application.properties`:

```properties
spring.application.name=stock-trading-server
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/rajat
spring.datasource.username=root
spring.datasource.password=NewPass123(YourPassword)

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

> Make sure your MySQL server is running and a database named `rajat` exists.

---

## ▶️ Running the Application

```bash
# Clone the repo
git clone https://github.com/18-RAJAT/Springboot-gRPC-Stock-Microservice-Server.git
cd Springboot-gRPC-Stock-Microservice-Server

# Build with Maven
mvn clean install

# Run the application
mvn spring-boot:run
```

The gRPC server will start on `localhost:9090`.

---

##  API (gRPC Endpoint)

### Service: `StockTradingService`

#### Method: `getStockPrice`

**Request**
```json
{
  "stock_symbol": "TCS"
}
```

**Response**
```json
{
  "stock_symbol": "TCS",
  "price": 3500,
  "timestamp": "2025-08-24T14:24:27"
}
```

---

##  Testing with Postman

1. Open Postman and select **gRPC**.
2. Enter the server address:
   ```
   localhost:9090
   ```
3. Choose `StockTradingService/getStockPrice`.
4. Send the request:
   ```json
   {
     "stock_symbol": "TCS"
   }
   ```
5. You should see a response with stock price and timestamp.