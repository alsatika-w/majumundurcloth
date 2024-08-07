This project provides a RESTful API for a warehouse management system, allowing merchants to manage products, and customers to make transactions and earn reward points. The API is built using Java with Spring Boot and PostgreSQL.
Key Features
    Merchant Capabilities:
        Create, update, and delete products.
    Customer Capabilities:
        View a list of products.
        Make transactions and earn reward points.
    Reward System:
        Reward A: 20 points
        Reward B: 40 points

Installation
Prerequisites
 Java 17
    Maven
    PostgreSQL
    IDE (e.g., IntelliJ IDEA, Eclipse)

Clone the Repository

Configuration
1. Database Setup
Configure your PostgreSQL database in src/main/resources/application.properties:
2. Build the Project using Maven: mvn clean install
3. Running the Application

Authentication
Authentication is required for accessing certain endpoints. Use HTTP Basic Authentication with the credentials configured in your database.
- API Endpoints Products: api/product 
- Get Customers by Product: /api/product/{productId}/customer
