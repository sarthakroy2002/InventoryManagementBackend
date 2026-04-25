# Inventory Management System

A Inventory Management System built using Spring Boot and SQLite. This project handles product tracking, stock updates, customer-linked sales, and basic inventory operations.

---

## Features

* CRUD Product management (add, update, delete, view)
* Inventory tracking with stock quantity
* Customer management
* Sales tracking linked with customers
* SQLite-based lightweight database
* REST APIs for all operations

---

## Tech Stack

* **Backend:** Spring Boot
* **Database:** SQLite
* **ORM:** Hibernate / JPA
* **Build Tool:** Maven
* **Language:** Java

---

## Setup Instructions

### 1. Clone the Repository

```cmd
git clone https://github.com/sarthakroy2002/InventoryManagementBackend
cd inventory-management
```

### 2. Configure Database

* SQLite DB is located in:

```cmd
datasource/inventorymgmt.db
```

* Update `application.properties` if needed:

```text
spring.datasource.url=jdbc:sqlite:datasource/inventorymgmt.db
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.jpa.database-platform=org.hibernate.community.dialect.SQLiteDialect
```

---

### 3. Run the Application

Using Maven:

```cmd
mvn spring-boot:run
```

Or run the main class directly from your IDE.

---

## Database Tables

[Database Tables](datasource/README.md)

---

## Notes

* SQLite is used for simplicity and portability (no server required)
* Designed for easy migration to MySQL/PostgreSQL later
* Initial version focuses on core inventory flow (not production hardened yet)

---

## Author

Sarthak Roy

---
