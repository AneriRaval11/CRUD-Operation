# 🛠️ Spring Boot CRUD REST API - Layered Architecture

This project is a complete implementation of a **Spring Boot CRUD REST API** using a clean layered architecture.

## 📚 Features

- Full CRUD operations for `Item`
- Clean architecture:
    - Controller
    - Service + Interface
    - DAO layer
    - Repository layer
    - Mapper
    - Validator
    - DTO
    - Custom Exceptions
- H2 In-memory Database
- Lombok to reduce boilerplate
---

## 🛠 Technologies Used

- Java 21
- Spring Boot 3.4
- Spring Data JPA
- H2 Database
- Lombok
- Maven
- Postman (for testing APIs)

---

## 🔧 Running the Application
- mvn clean install
- mvn spring-boot:run

---
## Access H2 Console
- URL: http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:testdb

- Username: (blank)

- Password: (blank)

---

## API Endpoints

| Method | Endpoint          | Description       |
| ------ | ----------------- | ----------------- |
| POST   | `/api/items`      | Create new Item   |
| GET    | `/api/items`      | Get all items     |
| GET    | `/api/items/{id}` | Get item by ID    |
| PUT    | `/api/items/{id}` | Update item by ID |
| DELETE | `/api/items/{id}` | Delete item by ID |

---
## JSON for POST 

{\
  "name": "Wireless Mouse", \
  "price": 500.0,\
  "discount": 10\
}
