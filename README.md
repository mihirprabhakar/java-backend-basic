
# Java Backend

Basic Java backend project setup.

## Project Structure

```text
project-name/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── application/
│   │   │               ├── controller/
│   │   │               ├── service/
│   │   │               ├── repository/
│   │   │               ├── model/
│   │   │               ├── dto/
│   │   │               ├── config/
│   │   │               └── Application.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│
├── .gitignore
├── pom.xml
└── README.md
```

## Folder Overview

* `controller/` — API endpoints and HTTP requests
* `service/` — Business logic
* `repository/` — Database access
* `model/` — Entities and domain models
* `dto/` — Request and response objects
* `config/` — Application configuration
* `resources/` — Configuration and other resources
* `test/` — Unit and integration tests

## Getting Started

### Prerequisites

* Java 17+
* Maven

### Run

```Shell
.\mvnw.cmd spring-boot:run 
```

### Build

```bash
mvn clean package
```

## Status

Initial backend project structure.
