# 🛒 E-Commerce Backend API

A production-ready RESTful backend for an e-commerce platform built with **Spring Boot**, secured with **JWT authentication**, and deployed on **Render**.

---

## 🔗 Live Links

- **Swagger UI:** [Live API Documentation](https://springboot-e-commerce-backend-project.onrender.com/swagger-ui/index.html)
- **GitHub:** [Source Code](https://github.com/ShreyaLambodari/SpringBoot---E-commerce-Backend-Project)

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Framework | Spring Boot 4|
| Language | Java 21 |
| Database | MySQL (Railway) |
| ORM | Spring Data JPA / Hibernate |
| Security | Spring Security + JWT |
| Build Tool | Maven |
| Containerization | Docker |
| Deployment | Render |
| API Docs | Swagger UI (OpenAPI 3) |

---

## ✨ Features

- ✅ RESTful CRUD APIs for Products, Categories, and Users
- ✅ JWT-based authentication and stateless session management
- ✅ Role-based authorization — `ADMIN` and `USER` roles
- ✅ DTO architecture with clean separation of concerns
- ✅ Global exception handling
- ✅ Input validation using Bean Validation (`@NotBlank`, `@Email`, etc.)
- ✅ Password encryption using BCrypt
- ✅ Swagger UI for interactive API documentation
- ✅ Dockerized and deployed on cloud

---

## 📁 Project Structure

```
src/main/java/com/ecom_proj/ecommerce/
├── controller/        # REST API controllers
├── service/           # Business logic layer
├── repository/        # Spring Data JPA repositories
├── entity/            # JPA entities
├── dto/               # Data Transfer Objects
├── security/          # JWT filter, config, service
└── exception/         # Global exception handler
```

---

## 🔐 API Endpoints

### Auth
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/auth/login` | Public |

### User
| Method | Endpoint | Access |
|--------|----------|--------|
| POST | `/api/user/register` | Public |
| GET | `/api/user/` | Authenticated |
| PUT | `/api/user/{id}` | Authenticated |
| DELETE | `/api/user/{id}` | Authenticated |

### Product
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/product/` | Public |
| GET | `/api/product/{id}` | Public |
| POST | `/api/product/` | ADMIN only |
| PUT | `/api/product/{id}` | ADMIN only |
| DELETE | `/api/product/{id}` | ADMIN only |

### Category
| Method | Endpoint | Access |
|--------|----------|--------|
| GET | `/api/category/` | Public |
| GET | `/api/category/{id}` | Public |
| POST | `/api/category/` | ADMIN only |
| PUT | `/api/category/{id}` | ADMIN only |
| DELETE | `/api/category/{id}` | ADMIN only |

---

## 🚀 Running Locally

### Prerequisites
- Java 21
- Maven
- MySQL

### Steps

```bash
# Clone the repository
git clone https://github.com/ShreyaLambodari/SpringBoot---E-commerce-Backend-Project.git
cd SpringBoot---E-commerce-Backend-Project
```

Set up your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

```bash
# Run the app
./mvnw spring-boot:run
```

App will start at `http://localhost:8080`

---

## 🐳 Running with Docker

```bash
docker build -t ecommerce-backend .
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://your-db-host:3306/ecommerce \
  -e SPRING_DATASOURCE_USERNAME=your_username \
  -e SPRING_DATASOURCE_PASSWORD=your_password \
  ecommerce-backend
```

---

## 🌍 Environment Variables (Production)

| Variable | Description |
|----------|-------------|
| `SPRING_DATASOURCE_URL` | Full JDBC URL of your MySQL database |
| `SPRING_DATASOURCE_USERNAME` | Database username |
| `SPRING_DATASOURCE_PASSWORD` | Database password |

---


## 📸 Screenshots

### Swagger Home — All APIs
![Swagger Home](https://github.com/user-attachments/assets/6785d66a-d528-4886-a7b5-5146f80f98b4)

### Login API — JWT Token Generation
![Login API](https://github.com/user-attachments/assets/2a313611-3e13-4520-b024-901cd1a343ff)

### Authorize with Bearer Token
![Authorize](https://github.com/user-attachments/assets/2ba7f5db-021d-406e-a795-3486da3d1021)

### POST Product — ADMIN Only
![Post Product](https://github.com/user-attachments/assets/568529d1-c9f4-4d21-bd69-9dcdfd190de5)

---

## 👩‍💻 Author

**Shreya Lambodari**  
[GitHub](https://github.com/ShreyaLambodari) | [LinkedIn](https://www.linkedin.com/in/shreya-lambodari/)
