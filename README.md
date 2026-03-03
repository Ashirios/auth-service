
---

# Auth Service

An authentication and authorization microservice built with **Spring Boot 3**. This system provides secure user registration, credential storage, and JWT (JSON Web Token) issuance to protect a microservices architecture.

---

### Tech Stack

* **Runtime:** Java 21 (Eclipse Temurin)
* **Framework:** Spring Boot 3.x, Spring Security 6
* **Data:** Spring Data JPA, Hibernate
* **Database:** PostgreSQL 15
* **Mapping & Tools:** MapStruct, Lombok
* **DevOps:** Docker, Docker Compose (Multi-stage build)

---

### System Architecture

The project follows a **Layered Architecture** pattern to ensure separation of concerns:

1. **API Layer:** REST controllers handling incoming HTTP requests.
2. **Security Layer:** Custom `SecurityFilterChain` configuration, stateless session management, and **BCrypt** password hashing.
3. **Service Layer:** Core authentication logic and a custom implementation of `UserDetailsService`.
4. **Data Layer:** JPA repositories interfacing with PostgreSQL for persistent storage.

---

### Key Features

* **Stateless Authentication:** Utilizes JWTs instead of traditional server-side sessions for scalability.
* **Security Configuration:** CSRF disabled for REST interactions and granular CORS configuration.
* **Data Mapping:** MapStruct implementation to decouple database entities (`UserEntity`) from Data Transfer Objects (DTOs).
* **Containerization:** Optimized Dockerfile using **multi-stage builds** to separate the build environment from the lightweight runtime image.

---

### Project Structure

```text
├── src/main/java/com/github/Ashirios/auth_service
│   ├── config/          # Security beans and encryption configuration
│   ├── controller/      # REST endpoints for access management
│   ├── dto/             # Request/Response DTO objects
│   ├── entity/          # Database entities
│   ├── enums/           # Role definitions (RBAC)
│   ├── mapper/          # MapStruct interfaces
│   ├── repository/      # Database abstraction layer
│   ├── service/         # Auth logic and UserDetails implementation
│   └── util/            # JWT utility tools and constants
└── docker-compose.yaml  # Service orchestration (App + DB)

```

---

### Deployment Guide

To run the service locally, you will need **Docker** and **Docker Compose** installed.

1. **Clone the Repository:**
```bash
git clone https://github.com/Ashirios/auth-service.git
cd auth-service

```


2. **Spin up the Infrastructure:**
```bash
docker compose up --build

```


3. **Verify Status:**
The service will be available at `http://localhost:8080`. For debugging, the PostgreSQL instance is exposed on local port `5433`.

---

### API Endpoints

| Method | Path | Description | Access |
| --- | --- | --- | --- |
| **POST** | `/api/auth/register` | Register a new account | Public |
| **POST** | `/api/auth/login` | Authenticate and receive token | Public |
| **GET** | `/api/users/me` | Retrieve current profile data | Authorized Only |

---

### Suggested Polish:

Since you are using **Java 21**, you might want to mention if you are utilizing **Virtual Threads** (Project Loom) in your `application.properties`, as that’s a huge selling point for modern Spring Boot performance!
