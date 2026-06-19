# Library Management API

## Technology Stack
- Java 17
- Spring Boot 3.2.5
- Spring Data JPA (Hibernate)
- PostgreSQL
- Lombok
- Maven

## How to Run
1. Ensure you have PostgreSQL running.
2. Create a database named `library_db` or let Spring Boot create it (configured in `application.properties`).
3. Update `src/main/resources/application.properties` with your PostgreSQL credentials.
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Users
- `POST /users`: Create a user (automatically creates a profile).
- `GET /users`: Get all users.
- `GET /users/{id}`: Get user by ID.

### Books
- `POST /books`: Create a book (assign existing author and categories).
- `GET /books`: Get all books.
- `GET /books/{id}`: Get book by ID.
- `PUT /books/{id}/borrow/{userId}`: Borrow a book.

### Authors
- `POST /authors`: Create an author.
- `GET /authors`: Get all authors.
- `GET /authors/{id}/books`: Get all books by a specific author.

### Categories
- `POST /categories`: Create a category.
- `GET /categories`: Get all categories.

## Relationships
- **User ↔ Profile**: One-to-One (Bidirectional)
- **User → Books**: One-to-Many (Borrowed books)
- **Book → Author**: Many-to-One
- **Book ↔ Category**: Many-to-Many
