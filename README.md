# 💰 Personal Finance Tracker - Backend

## 📌 Project Overview

The Personal Finance Tracker Backend is a Spring Boot REST API that enables users to securely manage their personal finances. It provides authentication, transaction management, budget management, dashboard summaries, and financial reports.

This backend is designed to work with the Angular frontend application.

---

## ✨ Features

- User Registration
- User Login using JWT Authentication
- Secure REST APIs with Spring Security
- Password Encryption using BCrypt
- Transaction Management (CRUD)
- Budget Management (CRUD)
- Dashboard Summary
- Financial Reports
- User-specific Data Access
- Global Exception Handling
- Request Validation
- MySQL Database Integration

---

## 🛠 Technology Stack

- Java 21
- Spring Boot 3
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 📂 Project Structure

```text
src
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
└── util
```

---

## 🔐 Security Features

- JWT Authentication
- BCrypt Password Encryption
- Route Protection
- User-specific Transactions
- User-specific Budgets

---

## 📡 REST API Modules

### Authentication

- Register User
- Login User

### Dashboard

- Dashboard Summary

### Transactions

- Add Transaction
- View Transactions
- Update Transaction
- Delete Transaction

### Budgets

- Add Budget
- View Budgets
- Update Budget
- Delete Budget

### Reports

- Monthly Financial Report

---

## 🗄 Database

MySQL

Main Tables:

- Users
- Transactions
- Budgets

---

## ⚙️ Installation

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open in IntelliJ IDEA

3. Configure MySQL database

4. Update `application.properties`

5. Run the application

---

## 🚀 Future Enhancements

- Export Reports as PDF
- Email Notifications
- Charts & Analytics
- Recurring Transactions
- Profile Management

---

## 👩‍💻 Author

**Nandini Karjala**

Java Full Stack Developer
