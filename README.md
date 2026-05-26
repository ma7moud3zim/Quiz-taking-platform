# 📝 Quiz Taking Platform

A full-stack web application for **creating, managing, and taking quizzes**. Built with **Java Spring Boot** as a REST API backend and **Angular** for the frontend.

---
## ✨ Features

- 🔐 **Authentication & Authorization** — Secure login and registration with role-based access (Admin / User)
- 📋 **Quiz Management** — Admins can create, edit, and delete quizzes and questions
- ✅ **Take Quizzes** — Users can browse available quizzes and take them interactively
- 📊 **Instant Results** — View score and correct answers immediately after submission
- 🛡️ **Spring Security** — JWT-based or session-based authentication
- 📡 **REST API** — Clean, well-structured API endpoints consumed by the Angular frontend
---

## 🚀 Tech Stack

| Layer     | Technology                         |
|-----------|------------------------------------|
| Frontend  | Angular, TypeScript, SCSS          |
| Backend   | Java, Spring Boot, Spring Security |
| Database  | MySQL / PostgreSQL                 |
| API Style | RESTful                            |

---
## 📁 Project Structure

```
Quiz-taking-platform/
├── azimquiz/          # Spring Boot backend
│   ├── src/
│   │   └── main/
│   │       ├── java/  # Controllers, Services, Repositories, Models
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
│
└── azimquizfe/        # Angular frontend
    ├── src/
    │   ├── app/       # Components, Services, Guards, Models
    │   └── environments/
    └── package.json
```
## 🗄 The Database Scheme at MySQL 
<img width="724" height="647" alt="image" src="https://github.com/user-attachments/assets/b38ae97c-ee7b-4b20-9a34-bb7d4456fd3d" />

---
## 📸 Screenshots

### Login Page
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/0a2816c9-4693-42d6-b5c5-cf1dd0e4c1fa" />

### Register Page
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/b0a0b1d0-4bdf-470d-88ab-ab45e52cc929" />


### Admin Dashboard and the Quiz List in it
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/06945ed2-1a08-422c-88a1-1c341acabb4d" />

### Viewing the Results by Admin
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/2513dcbe-100b-4a71-976e-efd1449cda26" />

### Viewing Test by Admin
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/38b71504-b943-435b-98f3-6b9f86a05a1a" />

### Adding Question by Admin
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/f1f4d0a3-bfee-4b23-b32d-4569db698551" />

### User Dashboard and the tests list
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/cca75348-3433-4016-a633-1bdfc4ed8a50" />

### Test example for the user
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/9d2c580b-7c74-4896-81be-821d157d832e" />

### tests Results
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/b8fbf293-1568-4859-b5e6-00cd9882ea0a" />

---

## ⚙️ Getting Started

### Prerequisites

- Java 17+
- Node.js 18+ & npm
- MySQL or PostgreSQL running locally
- Angular CLI (`npm install -g @angular/cli`)

---

### 🔧 Backend Setup

1. Navigate to the backend directory:
   ```bash
   cd azimquiz
   ```

2. Configure your database in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Build and run:
   ```bash
   ./mvnw spring-boot:run
   ```

   The backend will start on `http://localhost:8080`.

---

### 🎨 Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd azimquizfe
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   ng serve
   ```

   The app will be available at `http://localhost:4200`.

---

## 🌐 API Endpoints

### 🔐 Auth — `/api/auth`

| Method | Endpoint            | Description                        |
|--------|---------------------|------------------------------------|
| POST   | `/api/auth/sign-up` | Register a new user                |
| POST   | `/api/auth/login`   | Login with email and password      |

### 📝 Test — `/api/test`

| Method | Endpoint                        | Description                              |
|--------|---------------------------------|------------------------------------------|
| POST   | `/api/test`                     | Create a new test                        |
| POST   | `/api/test/question`            | Add a question to a test                 |
| GET    | `/api/test`                     | Get all tests                            |
| GET    | `/api/test/{id}`                | Get all questions of a specific test     |
| POST   | `/api/test/submit-test`         | Submit answers for a test                |
| GET    | `/api/test/test-result`         | Get all test results                     |
| GET    | `/api/test/test-result/{id}`    | Get all test results for a specific user |

---

## 🤝 Contributing

Contributions are welcome! To get started:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Open a Pull Request

---
## 👤 Author

**Mahmoud Azim**  
GitHub: [@ma7moud3zim](https://github.com/ma7moud3zim)
