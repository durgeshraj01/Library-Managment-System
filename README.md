# 📚 Library Management System API

A production-ready RESTful API for managing a library system, built with **Java 17**, **Spring Boot 3.2**, and **PostgreSQL**. It supports full book management, user registration, author and category handling, and a book borrowing system — all following a clean 3-layer MVC architecture.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.2.5 |
| Database | PostgreSQL |
| ORM | Hibernate (via Spring Data JPA) |
| Connection Pool | HikariCP |
| JSON Serialization | Jackson |
| Build Tool | Maven |
| IDE | Eclipse |

---

## 📁 Project Structure

```
library-management-api/
├── src/main/java/com/example/library/
│   ├── LMS.java                        # Main application entry point
│   ├── controller/
│   │   ├── BookController.java
│   │   ├── AuthorController.java
│   │   ├── CategoryController.java
│   │   └── UserController.java
│   ├── service/
│   │   ├── BookService.java
│   │   ├── AuthorService.java
│   │   ├── CategoryService.java
│   │   └── UserService.java
│   ├── repository/
│   │   ├── BookRepository.java
│   │   ├── AuthorRepository.java
│   │   ├── CategoryRepository.java
│   │   ├── UserRepository.java
│   │   └── ProfileRepository.java
│   └── entity/
│       ├── Book.java
│       ├── Author.java
│       ├── Category.java
│       ├── User.java
│       └── Profile.java
└── src/main/resources/
    └── application.properties
```

---

## ✨ Features

- ✅ Create and retrieve **Books** with author and category associations
- ✅ **Book Borrowing System** — borrow a book and track availability
- ✅ **Author Management** — add authors and view their books
- ✅ **Category Management** — organize books into multiple categories
- ✅ **User Registration** with auto-linked Profile (email, phone, address)
- ✅ Transactional business logic to ensure data consistency
- ✅ Clean 3-layer architecture: Controller → Service → Repository

---

## 🗃️ Entity Relationships

```
User (1) ──── (1) Profile
User (1) ──── (N) Book          [borrowedBooks]
Author (1) ── (N) Book
Book (N) ──── (N) Category      [via book_category join table]
```

---

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL installed and running

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/library-management-api.git
cd library-management-api
```

### 2. Create PostgreSQL Database
```sql
CREATE DATABASE library_db;
```

### 3. Configure application.properties
Update `src/main/resources/application.properties` with your credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### 4. Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

The API will start at: `http://localhost:8080`

---

## 📡 API Endpoints

### 👤 Users

| Method | Endpoint | Description |
|---|---|---|
| POST | `/users` | Create a new user with profile |
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |

**POST /users — Request Body:**
```json
{
    "name": "John Doe",
    "profile": {
        "email": "john.doe@example.com",
        "phone": "1234567890",
        "address": "123 Main St"
    }
}
```

---

### ✍️ Authors

| Method | Endpoint | Description |
|---|---|---|
| POST | `/authors` | Create a new author |
| GET | `/authors` | Get all authors |
| GET | `/authors/{id}/books` | Get all books by an author |

**POST /authors — Request Body:**
```json
{
    "name": "J.K. Rowling"
}
```

---

### 🏷️ Categories

| Method | Endpoint | Description |
|---|---|---|
| POST | `/categories` | Create a new category |
| GET | `/categories` | Get all categories |

**POST /categories — Request Body:**
```json
{
    "name": "Fantasy"
}
```

---

### 📖 Books

| Method | Endpoint | Description |
|---|---|---|
| POST | `/books` | Add a new book |
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get book by ID |
| PUT | `/books/{id}/borrow/{userId}` | Borrow a book |

**POST /books — Request Body:**
```json
{
    "title": "Harry Potter and the Sorcerer's Stone",
    "isbn": "978-0439708180",
    "author": { "id": 1 },
    "categories": [{ "id": 1 }]
}
```

**PUT /books/1/borrow/1 — Response:**
```json
{
    "id": 1,
    "title": "Harry Potter and the Sorcerer's Stone",
    "isbn": "978-0439708180",
    "available": false,
    "categories": [{ "id": 1, "name": "Fantasy" }]
}
```

---

## 🔁 Recommended Usage Order

To test the full flow, call the APIs in this order:

```
1. POST /users        → Create a user
2. POST /authors      → Create an author
3. POST /categories   → Create a category
4. POST /books        → Create a book (link author + category)
5. PUT  /books/{id}/borrow/{userId}  → Borrow the book
```

---

## 🏗️ Architecture

This project follows a clean **3-Layer Monolithic Architecture**:

```
[ REST Client ]
      ↓
[ Controller Layer ]  →  Handles HTTP requests & responses
      ↓
[ Service Layer ]     →  Business logic & @Transactional operations
      ↓
[ Repository Layer ]  →  JpaRepository interfaces for DB access
      ↓
[ PostgreSQL Database ]
```

---

## 📌 Notes

- Tables are auto-created/updated by Hibernate (`ddl-auto=update`)
- All relationships handle circular JSON serialization via `@JsonManagedReference` / `@JsonBackReference`
- User creation automatically initializes a linked Profile if not provided

---

## 👨‍💻 Author

**Your Name**
- GitHub: [@your-username](https://github.com/your-username)
- LinkedIn: [your-linkedin](https://linkedin.com/in/your-linkedin)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
