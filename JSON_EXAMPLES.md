# Library Management API JSON Examples

## Users

### POST /users
**Request:**
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
**Response:**
```json
{
    "id": 1,
    "name": "John Doe",
    "profile": {
        "id": 1,
        "email": "john.doe@example.com",
        "phone": "1234567890",
        "address": "123 Main St"
    },
    "borrowedBooks": []
}
```

### GET /users
**Response:**
```json
[
    {
        "id": 1,
        "name": "John Doe",
        "profile": {
            "id": 1,
            "email": "john.doe@example.com",
            "phone": "1234567890",
            "address": "123 Main St"
        },
        "borrowedBooks": []
    }
]
```

## Authors

### POST /authors
**Request:**
```json
{
    "name": "J.K. Rowling"
}
```
**Response:**
```json
{
    "id": 1,
    "name": "J.K. Rowling",
    "books": null
}
```

## Categories

### POST /categories
**Request:**
```json
{
    "name": "Fantasy"
}
```
**Response:**
```json
{
    "id": 1,
    "name": "Fantasy"
}
```

## Books

### POST /books
**Request:**
```json
{
    "title": "Harry Potter and the Sorcerer's Stone",
    "isbn": "978-0439708180",
    "author": {
        "id": 1
    },
    "categories": [
        {
            "id": 1
        }
    ]
}
```
**Response:**
```json
{
    "id": 1,
    "title": "Harry Potter and the Sorcerer's Stone",
    "isbn": "978-0439708180",
    "available": true,
    "categories": [
        {
            "id": 1,
            "name": "Fantasy"
        }
    ]
}
```

### PUT /books/{id}/borrow/{userId}
**URL:** `/books/1/borrow/1`
**Response:**
```json
{
    "id": 1,
    "title": "Harry Potter and the Sorcerer's Stone",
    "isbn": "978-0439708180",
    "available": false,
    "categories": [
        {
            "id": 1,
            "name": "Fantasy"
        }
    ]
}
```
