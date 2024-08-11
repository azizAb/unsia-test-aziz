# Unsia Hiring Test

## Overview

This repository contains a Spring Boot project designed as a test for the hiring process at Unsia. The project demonstrates the use of several frameworks, including Spring JPA, Lombok, and MS SQL, to create a RESTful API service.

## Technologies Used

- **Java**: Version 21
- **Spring Boot**: Version 3.3.2
- **Spring Data JPA**: For database interaction
- **Lombok**: To reduce boilerplate code
- **MS SQL**: As the database

## Project Structure

The project is structured into several modules, each handling a specific part of the application. The key modules include:

- **Program API**: Handles CRUD operations for program entities.
- **Kegiatan API**: Handles CRUD operations for kegiatan entities.
- **Dashboard API**: Provides a summary and accumulated data related to both program and kegiatan entities.

## REST API Endpoints

The REST API endpoints for the project are organized as follows:

1. **Program API**: 4 endpoints for creating, retrieving, updating, and deleting programs.
2. **Kegiatan API**: 4 endpoints for creating, retrieving, updating, and deleting kegiatan.
3. **Dashboard API**: 1 endpoint for retrieving accumulated data related to programs and kegiatan.

## Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven**
- **MS SQL Server**

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/azizAb/unsia-test-aziz.git
   ```

2. **Configure the database**:
    - Update the `application.properties` file with your MS SQL database credentials.

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the project**:
   ```bash
   mvn spring-boot:run
   ```

### Testing

- Use Postman to import the provided collection and test the API endpoints.
- The APIs are designed for CRUD operations on program and kegiatan entities and to fetch accumulated data through the dashboard API.
