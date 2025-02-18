# Voting Survey

## Overview
The **Voting Survey** project provides a RESTful API for user management, including registration, login, retrieving users, updating user details, and deleting users.

## API Endpoints

| S.No | Endpoint                          | Method | Description             |
|------|----------------------------------|--------|-------------------------|
| 1    | `localhost:5173/api/user/register` | POST   | Register a new user    |
| 2    | `localhost:5173/api/user/login`    | POST   | User login             |
| 3    | `localhost:5173/api/user`          | GET    | Retrieve all users     |
| 4    | `localhost:5173/api/user/{id}`     | GET    | Get user by ID        |
| 5    | `localhost:5173/api/user/{id}`     | DELETE | Delete user by ID     |
| 6    | `localhost:5173/api/user/{id}`     | PUT    | Update user details   |

## Usage
- Ensure the backend server is running on `localhost:5173`.
- Use API testing tools like Postman or cURL to interact with the endpoints.

## Technologies Used
- Java (Spring Boot)
- REST API
- MySQL/PostgreSQL (Database)
- Hibernate (ORM)
- Maven (Build Tool)
- Spring Data JPA
- Lombok (Simplified Java Code)
- H2 Database (In-memory testing)

## Installation & Setup
1. Fork the repository from GitHub.
2. Clone your forked repository:
   ```sh
   git clone https://github.com/MdMohsinHaider/voting-survey-spring-boot-backend.git
   ```
3. Navigate to the project directory:
   ```sh
   cd voting-survey
   ```
4. Build the project using Maven:
   ```sh
   mvn clean install
   ```
5. Run the Spring Boot application:
   ```sh
   mvn spring-boot:run
   ```

## Author
Md Mohsin Haider
