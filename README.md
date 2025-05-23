# 🛒 Ecommerce Microservices Application

A scalable and modular Ecommerce platform built with **Spring Boot** and **Microservices Architecture**. This project demonstrates clean architecture, secure communication, and performance optimizations for real-world ecommerce workflows.

## 🚀 Features

- 🧾 Product Management (CRUD, Search)
- 👤 User Registration & Authentication (JWT-based)
- 🛍 Order Management
- 📧 Event-driven Email Notification Service
- ⚙️ Microservices Architecture with Spring Boot
- 🚀 Redis Caching for Performance
- 🔐 Spring Security for Authentication and Authorization

## 🛠 Tech Stack

- **Backend**: Java, Spring Boot, Spring Data JPA, Spring Security
- **Database**: MySQL
- **Cache**: Redis
- **Message Queue**: RabbitMQ (can upgrade to Kafka)
- **Build Tool**: Maven
- **Version Control**: Git
- **Monitoring**: Spring Boot Actuator

## 📁 Microservices Overview

```bash
ecommerce/
│
├── product-service/         # Manages products
├── user-service/            # Handles user registration and login
├── order-service/           # Processes orders
├── email-service/           # Sends order-related emails
├── api-gateway/             # Routes requests (optional if using Zuul/Nginx)
└── config-server/           # Centralized configuration (optional)
