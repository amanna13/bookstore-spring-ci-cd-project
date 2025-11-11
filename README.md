# 📚 Bookstore Spring CI/CD Project

A DevOps-focused Bookstore API built with **Spring Boot** featuring an **automated build and test pipeline** using **Jenkins**.

---

## Overview
This project demonstrates a complete **CI/CD pipeline** for a Java Spring Boot application.  
Each commit automatically triggers:
1. Code formatting and static analysis  
2. Unit testing  
3. Build and package  
4. Docker image creation and push  

---

## Tech Stack
- **Java 17+**
- **Spring Boot**
- **Maven**
- **Jenkins**
- **Docker**

---

## ⚙️Run Locally
```bash
# Clone the repo
git clone https://github.com/<your-username>/bookstore-spring-ci-cd-project.git
cd bookstore-spring-ci-cd-project

# Build and run using Maven Wrapper
./mvnw clean package
java -jar target/*.jar

```

## Testing

Run all tests:
```
./mvnw test
```

## CI/CD Pipeline

The Jenkins pipeline automates:

- Build → Maven clean & package
- Test → Runs unit/integration tests
- Containerize → Builds Docker image
- Deploy → Push to container registry or server
