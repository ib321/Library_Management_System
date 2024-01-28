# Library_Management_System

## Project Description

The Library Management System is a software designed for monitoring and controlling various operations in a library. It allows users to search for books, check their availability, and know the return date of issued books. 

This project is based on CRUD operations, allowing users to create, read, update, and delete information about books. It also includes functionality for checking book availability based on return dates, creating users, storing user info with encrypted passwords, and basic user authentication.

## Key Features

- **CRUD Operations**: Create, read, update, and delete information about books.
- **Book Search**: Users can search for a particular book by its name, author, or category.
- **Availability Check**: Users can check if a particular book is issued or if it's available in stock.
- **User Authentication**: User login is implemented not based on token validation but a basic user creation and authentication. Password encryption is also implemented.

## Technologies Used

### Front-end:
- **TypeScript**
- **Angular**

### Back-end:
- **Java 1.8**
- **Spring Boot 2.3.3**
- **Spring DATA JPA**

### Database:
- **Oracle 11g**

### Server:
- **Tomcat 8.5**

## Architecture

The backend is based on a Spring Boot application where REST API-based requests are made and responses are returned as objects.
The frontend is Angular-based.
User login is implemented not based on token validation but a basic user creation and authentication. Password encryption is also implemented.