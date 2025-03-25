# Product Management System - Placeholder Project

A Spring Boot application template for building a product management system with REST API and OpenAPI documentation. This placeholder project serves as a starting point for your assignment and can be adapted to your specific requirements.

## Features

- Basic CRUD operations for product management
- RESTful API with comprehensive documentation
- PostgreSQL database integration
- DTO pattern implementation
- Ready-to-use project structure

## Tech Stack

- Java 21
- Spring Boot 3.2.2
- PostgreSQL
- OpenAPI (Swagger) for documentation
- MapStruct for object mapping
- Lombok for reducing boilerplate code

## Prerequisites

Before you begin, ensure you have:
- JDK 21
- Maven
- PostgreSQL
- Your favorite IDE (preferably IntelliJ IDEA)

## Getting Started

1. Clone the repository
2. Create PostgreSQL database:
```sql
CREATE DATABASE myprojectdb;
```

3. Configure database connection in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myprojectdb
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. Build the project:
```bash
mvn clean install
```

5. Run the application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## API Documentation

Access the Swagger UI to explore and test the API:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

### Testing with Swagger UI

1. Start your Spring Boot application
2. Go to `http://localhost:8080/swagger-ui.html` in your browser
3. Explore and test the available endpoints:
    - Expand the "Product Controller" section to see all endpoints
    - Click on an endpoint (e.g., GET `/api/v1/products`)
    - Click "Try it out", then "Execute"
    - View the response

### Testing with Postman

1. Download and install [Postman](https://www.postman.com/downloads/)
2. Create requests for the following endpoints:
    - GET `/api/v1/products` - List all products
    - GET `/api/v1/products/{id}` - Get product by ID
    - POST `/api/v1/products` - Create a new product
    - PUT `/api/v1/products/{id}` - Update a product
    - DELETE `/api/v1/products/{id}` - Delete a product

Example POST request body:
```json
{
  "name": "New Product",
  "description": "Product description",
  "price": 49.99,
  "quantity": 10
}
```

## Project Structure

```
src/main/java/com/myproject/
├── config/          # Configuration classes
├── controller/      # REST controllers
├── model/           # Entity classes
├── repository/      # Data access layer
├── service/         # Business logic
├── dto/             # Data Transfer Objects
├── mapper/          # Object mappers
└── exception/       # Exception handling
```

## Key Components

### Entity
The `Product` entity represents a product in the database with fields:
- id (primary key)
- name
- description
- price
- quantity

### Repository
The `ProductRepository` provides data access methods:
- Basic CRUD operations (from JpaRepository)
- Custom finder methods

### Service
The `ProductService` implements business logic:
- Get all products
- Get product by ID
- Create new product
- Update existing product
- Delete product

### Controller
The `ProductController` defines REST endpoints:
- GET `/api/v1/products` - Get all products
- GET `/api/v1/products/{id}` - Get product by ID
- POST `/api/v1/products` - Create new product
- PUT `/api/v1/products/{id}` - Update product
- DELETE `/api/v1/products/{id}` - Delete product

## Customization Guide

1. **Change Entity**: Modify or replace the `Product` entity with your own domain entities
2. **Define Relationships**: Set up one-to-many, many-to-many, or one-to-one relationships between your entities
3. **Create Repositories**: Add repositories for your new entities
4. **Implement Services**: Add business logic in the service layer
5. **Build Controllers**: Define REST endpoints for your entities
6. **Generate DTOs**: Create DTOs for data transfer
7. **Update Mappers**: Ensure mappers correctly convert between entities and DTOs

## Database Schema

For the placeholder project, there is a single table:
- Product (id, name, description, price, quantity)

When customizing, you'll need to define your own database schema with the necessary tables and relationships based on your requirements.

## Running Tests

```bash
mvn test
```

## Acknowledgments

- Spring Boot Team
- PostgreSQL Team
- OpenAPI Initiative




## Instructions from Canvas

Objective This assignment ensures that each
team member develops fundamental skills in building
REST APIs using Spring Boot by creating individual
endpoints and implementing basic CRUD operations.


### **1 - Develop REST API Endpoints**
- Each team member should design and implement 3-4 REST endpoints using Spring Boot.
- The API should include a mix of HTTP methods (GET, POST, PUT, DELETE).
- Implementation should follow the Spring Boot architecture patterns with proper separation of concerns.


### **2 - Required Components**
- Create 2-3 entity classes that represent your data models
-  Implement at least one service class with business logic
-  Create 1-2 repository interfaces for data access
-  Develop one controller class to handle HTTP requests
-  Include proper exception handling and response status codes


### **3 - Implementation Requirements**
- Use appropriate annotations (@RestController, @Service, @Repository, etc.)
- Implement proper request/response DTOs where necessary
- Include input validation using annotations (@Valid, @NotNull, etc.)
- Document your API endpoints using Swagger/OpenAPI annotations
- Follow RESTful naming conventions and best practices


### **4 - Technical Documentation**
- Provide documentation for each endpoint including:
  - HTTP method and URL path
  - Request/response formats with examples
  - Required parameters and their constraints
  - Possible response status codes
- Include setup instructions for running the API locally

### **5 - Submission Guidelines**
- Submit your Spring Boot project as a Git repository
- Include a README.md with:
  - Project setup instructions
  - API documentation
  - Examples of API usage
- Each team member should submit their individual implementation

**Note:** While the implementations are individual, 
ensure your API design aligns with the team's project 
domain and could potentially be integrated into the main project in the future.