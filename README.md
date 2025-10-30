# Quiz Service Microservice

## 📘 Overview

The **Quiz Service** is a microservice in the QuizApp ecosystem responsible for creating, retrieving, and submitting quizzes.  
It interacts with the Question Service for fetching questions, handles quiz creation based on categories, and evaluates user responses.

- **Architecture:** RESTful, Spring Boot
- **Inter-service Communication:** Feign Client (Spring Cloud OpenFeign)
- **Build Tool:** Maven

---

## ⚙️ Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Feign Client
- Maven

---

## 🏗️ Project Structure

```
quiz-service/
├── src/main/java/com/example/quizservice/
│   ├── QuestionWrapper.java
│   ├── Quiz.java
│   ├── QuizDto.java
│   ├── QuizServiceApplication.java
│   ├── Response.java
│   ├── controller/
│   │   └── QuizController.java
│   ├── Dao/
│   │   └── QuizDao.java
│   ├── feign/
│   │   └── QuizInterface.java
│   └── service/
│       └── QuizService.java
│
├── src/main/resources/
│   ├── static/
│   ├── templates/
│   ├── application.properties
│
└── src/test/java/
```

---

## 🚀 Endpoints

### 1️⃣ Create a Quiz

- **Endpoint:** `POST /quiz/create`
- **Description:** Create a new quiz using category, number of questions, and title.
- **Request Body:**
  ```json
  {
    "category": "Science",
    "numQ": 5,
    "title": "Basic Science Quiz"
  }
  ```
- **Responses:**
  - `200 OK` – Quiz created successfully
  - `400 Bad Request` – Invalid input

---

### 2️⃣ Get Quiz Questions

- **Endpoint:** `GET /quiz/get/{id}`
- **Description:** Fetch all questions for a given quiz ID.
- **Response Example:**
  ```json
  [
    {
      "id": 1,
      "questionTitle": "What is the boiling point of water?",
      "option1": "90°C",
      "option2": "100°C",
      "option3": "80°C",
      "option4": "120°C"
    }
  ]
  ```

---

### 3️⃣ Submit Quiz

- **Endpoint:** `POST /quiz/submit/{id}`
- **Description:** Submit user responses and return the total score.
- **Request Body Example:**
  ```json
  [
    {
      "questionId": 1,
      "response": "100°C"
    },
    {
      "questionId": 2,
      "response": "Mars"
    }
  ]
  ```
- **Response Example:**
  ```
  3
  ```
  (Indicates the total number of correct answers)

---

## 🧩 Key Classes

| Class                | Description                                               |
|----------------------|-----------------------------------------------------------|
| `QuizController`     | Exposes REST APIs for quiz operations                     |
| `QuizService`        | Handles business logic for quiz creation, fetching, etc.  |
| `QuizDao`            | Data access layer for quiz entities                       |
| `QuizInterface`      | Feign client for communicating with Question microservice |
| `QuizDto`, `Response`, `QuestionWrapper` | Data transfer and wrapper classes     |

---

## 🧠 How to Run

1. **Clone the repository:**
    ```sh
    git clone https://github.com/your-repo/quiz-service.git
    ```

2. **Navigate into the project:**
    ```sh
    cd quiz-service
    ```

3. **Build and run the service:**
    ```sh
    mvn spring-boot:run
    ```

4. **Service runs at:**  
   [http://localhost:8081/](http://localhost:8081/)

---

## 🔗 Integration

This service is part of a microservice-based Quiz Application:

- **Question Service** – Manages question bank.
- **Quiz Service** – Creates and evaluates quizzes.

Services communicate via **Spring Cloud OpenFeign**.

---

## 📚 Contributing & Next Steps

- Add validation using `@Valid` DTOs for better error handling.
- Integrate Swagger/OpenAPI for API documentation.
- Add logging and metrics for production readiness.
- Write unit and integration tests in `src/test/java`.