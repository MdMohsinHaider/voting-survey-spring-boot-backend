# Voting Survey

## Overview
The **Voting Survey** project provides a RESTful API for managing user registrations, logins, constituencies, and administrative functionalities. It allows users to register, log in, and manage voting-related data efficiently.

## Author
**Md Mohsin Haider**  
Java Full Stack Developer

## **📌 Features & Working of the Project**

### **🔹 User (Voter) Functionalities**
1️⃣ **User Registration & Login:**  
   - New users must register with **Name, Email, Password, and Constituency**.  
   - If already registered, users can log in and access their dashboard.  

2️⃣ **User Dashboard:**  
   - **User Details Section:** Displays the voter’s profile and constituency.  
   - **Candidates List:** Shows all election candidates in the user's constituency when the election is live.  
   - **Search Bar:** Allows users to search previous election results and other constituency details.  

3️⃣ **Voting Process:**  
   - Users can vote for any candidate **only during active elections**.  
   - Once a vote is cast, the **Vote button is disabled** to prevent multiple voting.  
   - In future elections, users can log in and vote again.  

4️⃣ **Real-Time Election Results:**  
   - Votes are updated **instantly** as users vote.  
   - The **party with the most votes is automatically ranked first**.  
   - Results are visible to everyone, ensuring transparency.  

---

### **🔴 Admin Functionalities**
1️⃣ **Admin Login:**  
   - Admins log in to access the election management panel.  

2️⃣ **Election Management:**  
   - **Register new candidates** for elections.  
   - **Add constituencies** and assign candidates.  
   - **Start or close elections** at any time.  

3️⃣ **Candidate & Party Management:**  
   - Admins can **delete candidates or parties** if needed.  

4️⃣ **Monitoring Election Activities:**  
   - Admins can **track votes in real-time**, view **which users have voted**, and monitor **total votes per candidate**.  
   - Admins can access a **list of all constituencies** and their assigned candidates.  

---

## API Endpoints

### Admin Endpoints

| S.No | Endpoint                          | Method | Description          |
|------|----------------------------------|--------|----------------------|
| 1    | `http://localhost:8090/api/admin/auth` | POST   | Admin login        |
| 2    | `http://localhost:8090/api/admin/{id}` | GET    | Get admin by ID    |

**Request Body for Admin Login:**
```json
{
    "id": 123,
    "password": "admin12345"
}
```

### User Endpoints

| S.No | Endpoint                          | Method | Description                                  |
|------|----------------------------------|--------|----------------------------------------------|
| 1    | `http://localhost:8090/api/user/register` | POST   | Register a new user                         |
| 2    | `http://localhost:8090/api/user/login`    | POST   | User login                                  |
| 3    | `http://localhost:8090/api/user`          | GET    | Retrieve all users                          |
| 4    | `http://localhost:8090/api/user/{id}`     | GET    | Get user by ID                             |
| 5    | `http://localhost:8090/api/user/{id}`     | DELETE | Delete user by ID                          |
| 6    | `http://localhost:8090/api/user/{id}`     | PUT    | Update user details                        |
| 7    | `http://localhost:8090/api/user/voterId/{voterId}` | GET | Get user by voter ID                      |
| 8    | `http://localhost:8090/api/user/email/{email}` | GET | Get user by email                         |
| 9    | `http://localhost:8090/api/user/constituency/{name}` | GET | Get users by constituency name           |
| 10   | `http://localhost:8090/api/user/constituency/{state}/vote-status/{status}` | PUT | Update voting status for users in state |
| 11   | `http://localhost:8090/api/user/reset-votes/{constituencyNumber}` | PUT | Reset votes by constituency number      |
| 12   | `http://localhost:8090/api/user/voterId/{voterId}/vote-status/{status}` | PUT | Update voting status by voter ID       |

**Request Body for User Registration:**
```json
{
  "voterId": 99887766554433,
  "name": "Md Mohsin Haider",
  "email": "mdmohsinhaider@gamil.com",
  "password": "xyz123",
  "age": 7,
  "gender": "Male",
  "address": "Delhi",
  "constituency": "South Delhi",
  "constituencyNumber": 33
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
| 6    | `http://localhost:8090/api/constituency/allConstituencyByIdOrName?name={name}` | GET | Get constituency by name or ID |
| 7    | `http://localhost:8090/api/constituency/all` | POST  | Save multiple constituencies   |

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

### 🏳️ Party Endpoints

| S.No | Endpoint | Method | Description |
|------|----------|--------|-------------|
| 1 | `/api/party` | GET | Get all parties |
| 2 | `/api/party/byConstituencyIdOrName?constituencyId=33&constituencyName=Lucknow` | GET | Get parties by constituency ID or name |
| 3 | `/api/party/activeConstituenciePartys` | GET | Get parties in one recent active constituency |
| 4 | `/api/party/allActiveElectionParties` | GET | Get all active election parties |
| 5 | `/api/party/delete/{id}` | DELETE | Delete a party by ID |
| 6 | `/api/party/constituency-number/{number}` | GET | Get all parties by constituency number |
| 7 | `/api/party/{partyId}/votes?votes={voteCount}` | PUT | Update party vote count |
| 8 | `/api/party` | POST | Save party and candidate |
| 9 | `/api/party/resetVotes?constituencyId={id}` | PUT | Reset votes in a constituency |

#### 📥 Sample Save Party & Candidate
```json
{
  "name": "Democratic Party",
  "candidateName": "John Doe",
  "img": "https://example.com/images/party1.png",
  "candidateImg": "https://example.com/images/candidate1.png",
  "constituency": {
    "id": 1
  }
}
```

## Usage
- Ensure the backend server is running on `localhost:8090`.
- Use API testing tools like Postman or cURL to interact with the endpoints.

## Technologies Used
- Java (Spring Boot)
- REST API
- MySQL (Database)
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
│   │── application.properties
│── src/test/java
│── target/
│── pom.xml
│── README.md
```

## Working Description
The Voting Survey project operates as a centralized online voting system where users (voters) and admins interact through RESTful APIs. The system begins with user registration, where voters submit their personal and constituency details. Once authenticated via login, users gain access to a personalized dashboard that reflects live election data based on their assigned constituency. The election lifecycle is fully managed by the admin, who can activate or close elections, register candidates, and add constituencies.

When an election is live, eligible users can cast their vote for a candidate in their area, and the system ensures one vote per user by disabling the vote button post-submission. This vote is immediately reflected in real-time results visible to all users, ensuring transparency. Admins have advanced monitoring tools to view total votes per candidate, track who has voted, and manage party or candidate details dynamically. The backend system uses Spring Boot with Hibernate and JPA to interact with a MySQL or H2 database, maintaining data consistency and performance. Every functionality—from user authentication to vote tallying—is handled through well-defined API endpoints, which can be tested and integrated easily with frontend tools like React or API testers like Postman.

## **👨‍💻 Developed By**
This project was developed by **Md Mohsin Haider** as part of Java Full Stack Development using **Spring Boot (Backend)** and **React.js (Frontend)**.


