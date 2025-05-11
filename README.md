### Translation Management API

This is a Spring Boot-based API for managing translations. It includes JWT-based authentication and provides endpoints to create, update, and retrieve translations. The project uses H2 as the database for simplicity.

#### Features:
- JWT-based authentication for secure access.
- RESTful endpoints to manage translations.
- H2 in-memory database for development and testing.

#### Tech Stack:
- Spring Boot 3.4.5
- Spring Security
- JWT for authentication
- H2 Database
- Maven

### Project Structure:
- **Model:** Translation entity with fields for locale, key, content, and tag.
- **Repository:** Uses Spring Data JPA for database operations.
- **Service:** Handles business logic.
- **Controller:** Exposes RESTful endpoints.
- **Security:** Implements JWT-based authentication.

### Setup Instructions:
1. Clone the repository:
```
git clone https://github.com/maleemnadeem/translation-management-service.git
cd translation-management-api
```
2. Build and run the application:
```
mvn clean install
mvn spring-boot:run
```
3. Using Docker
## Running the Application

### Docker Compose
To build and run the application using Docker Compose:
```bash
docker-compose up --build -d
```

#### Accessing the Application
- The service will be available at: `http://localhost:8080`

#### Viewing Logs
To view the logs of the running container:
```bash
docker-compose logs -f
```

#### Stopping the Application
To stop and remove the container:
```bash
docker-compose down
```

### Building Docker Image Manually
If you prefer to build the Docker image manually:
```bash
docker build -t translation-management-service .
docker run -p 8080:8080 translation-management-service
```
4. Access the API:
- Login: POST `/api/auth/login`
- Validate Token: GET `/api/auth/validate`
- Translation CRUD: `/api/translations`

### JWT Authentication:
- Users obtain a token by logging in with a username and password.
- The token is required for all secured endpoints.
- Logout endpoint clears the session (optional).

### Design Choices:
- **JWT for Stateless Authentication:** Lightweight and easy to integrate with Spring Boot.
- **H2 Database:** Chosen for simplicity and ease of testing.
- **Spring Data JPA:** Reduces boilerplate for database access.

### Example Usage:
#### Login:
```
curl -X POST "http://localhost:8080/api/auth/login" -d "username=admin&password=password"
```
#### Accessing Secured Endpoint:
```
curl -X GET "http://localhost:8080/api/translations" -H "Authorization: Bearer <token>"