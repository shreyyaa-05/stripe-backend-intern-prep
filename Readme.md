# Transaction Management REST API

A Spring Boot–based REST API for managing users and financial transactions.

## Features
- User creation and retrieval
- Transaction creation and listing per user
- Input validation and custom exception handling
- Controller-level tests using MockMvc

## Tech Stack
- Java
- Spring Boot
- Maven
- JUnit, MockMvc

## API Endpoints
- POST /users
- GET /users
- POST /transactions
- GET /transactions/user/{userId}

## Architecture
- Controller–Service layered architecture
- RESTful design principles
