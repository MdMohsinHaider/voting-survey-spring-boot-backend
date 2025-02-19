# Voting Survey

## Overview
The **Voting Survey** project provides a RESTful API for managing user registrations, logins, constituencies, and administrative functionalities. It allows users to register, log in, and manage voting-related data efficiently.

## API Endpoints

### Admin Endpoints

| S.No | Endpoint                          | Method | Description          |
|------|----------------------------------|--------|----------------------|
| 1    | `http://localhost:8090/api/admin/auth` | POST   | Admin login        |
| 2    | `http://localhost:8090/api/admin/123` | GET    | Get admin by ID    |

**Request Body for Admin Login:**
```json
{
    "id": 123,
    "password": "admin12345"
}
```

### User Endpoints

| S.No | Endpoint                          | Method | Description             |
|------|----------------------------------|--------|-------------------------|
| 1    | `http://localhost:8090/api/user/register` | POST   | Register a new user    |
| 2    | `http://localhost:8090/api/user/login`    | POST   | User login             |
| 3    | `http://localhost:8090/api/user`          | GET    | Retrieve all users     |
| 4    | `http://localhost:8090/api/user/{id}`     | GET    | Get user by ID        |
| 5    | `http://localhost:8090/api/user/{id}`     | DELETE | Delete user by ID     |
| 6    | `http://localhost:8090/api/user/{id}`     | PUT    | Update user details   |
| 7    | `http://localhost:8090/api/user/voterId/{voterId}` | GET | Get user by voter ID |
| 8    | `http://localhost:8090/api/user/email/{email}` | GET | Get user by email    |

**Request Body for User Registration:**
```json
{
  "voterId": 12998834,
  "name": "Mohsin",
  "email": "Mohsin@example.com",
  "password": "mySecurePasswordmohsin",
  "age": 23,
  "gender": "Male",
  "address": "1234 Elm Street",
  "constituency": "City District 1",
  "hasVoted": true
}
```

### Constituency Endpoints

| S.No | Endpoint                          | Method | Description                      |
|------|----------------------------------|--------|----------------------------------|
| 1    | `http://localhost:8090/api/constituency` | POST   | Save constituency               |
| 2    | `http://localhost:8090/api/constituency` | GET    | Get all constituencies          |
| 3    | `http://localhost:8090/api/constituency/{id}` | GET    | Get constituency by ID          |
| 4    | `http://localhost:8090/api/constituency/state/{state}` | GET | Get constituency by state      |
| 5    | `http://localhost:8090/api/constituency/active` | GET | Get active constituencies      |
| 6    | `http://localhost:8090/api/constituency/all` | POST  | Save multiple constituencies   |

**Request Body for Saving a Constituency:**
```json
{
  "id": 1,
  "name": "North Delhi",
  "state": "Delhi",
  "electionActive": true,
  "dOLS": "2024-02-15"
}
```

## Usage
- Ensure the backend server is running on `localhost:8090`.
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

## Project Structure
```
/votingsurvey
│── src/main/java/com/jspider/votingsurvey
│   │── VotingsurveyApplication.java
│   │── controller
│   │   ├── AdminController.java
│   │   ├── ConstituencyController.java
│   │   └── UserController.java
│   │── dao
│   │   ├── ConstituencyDao.java
│   │   ├── ConstituencysDao.java
│   │   ├── UserDao.java
│   │   ├── UsersDao.java
│   │   └── dashboard
│   │       ├── AdminDao.java
│   │       └── AdminImpDao.java
│   │── entity
│   │   ├── Admin.java
│   │   ├── Constituency.java
│   │   ├── Party.java
│   │   └── User.java
│   │── repository
│   │   ├── AdminRepository.java
│   │   ├── ConstituencyRepository.java
│   │   └── UserRepository.java
│   │── services
│── src/main/resources
│   │── static
│   │── templates
│   │── application.properties
│── src/test/java
│── src/test/resources
│── target/generated-sources/annotations
│── target/generated-test-sources/test-annotations
│── src
│── target
│── HELP.md
│── mvnw
│── mvnw.cmd
│── pom.xml
│── README.md
```

## Jspider

