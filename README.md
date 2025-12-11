# Java Inventory Management System

A simple but robust desktop application built with Java Swing to manage retail inventory, track stock levels, and handle products using a MySQL database. This project was developed as an internship exercise to demonstrate core software engineering principles like database management, UI development, and error handling.

## Problem Statement

This system addresses the challenges of manual inventory tracking, which is often prone to errors, delays, and can lead to revenue loss. It provides a digital, efficient, and user-friendly solution to manage products and stock levels accurately.

## 📸 Screenshot
"C:\Users\Manas\Desktop\Inventory Project\Screenshot 2025-12-11 232528.png"

## ✨ Features

- **Full CRUD Functionality**: Add, find, update, and delete products from the inventory.
- **Real-Time Stock Tracking**: Update stock levels for sales or restocking.
- **Barcode-Based Lookup**: Instantly retrieve product details by scanning or typing a barcode.
- **Input Validation**: Prevents crashes and data corruption by validating user input (e.g., checks for empty fields and valid numbers).
- **Error Handling**: Graceful error messages for common issues like "Product Not Found" or database connection problems.
- **User-Friendly Interface**: A clean and simple GUI built with Java Swing for easy navigation.

## 🛠️ Tech Stack

- **Language**: Java
- **User Interface**: Java Swing (Core Java Library)
- **Database**: MySQL
- **Connectivity**: JDBC (MySQL Connector/J)
- **IDE**: Visual Studio Code

## 🚀 Getting Started

Follow these steps to set up and run the project on your local machine.

### Prerequisites

1.  **JDK 17 or newer**
2.  **MySQL Server** installed and running.
3.  **VS Code** with the "Extension Pack for Java" installed.

### 1. Database Setup

First, connect to your local MySQL server and run the following SQL script to create the database and tables:


### 2. Configure and Run

1.  Clone this repository to your local machine.
2.  Download the **MySQL Connector/J** (`.jar` file) from the official [MySQL website](https://dev.mysql.com/downloads/connector/j/).
3.  Open the project folder in VS Code.
4.  In the "JAVA PROJECTS" view, add the downloaded `.jar` file to **Referenced Libraries**.
5.  Open `src/InventoryManager.java` and update the `password` variable with your MySQL root password.
6.  Open `src/MainUI.java`, right-click, and select **Run Java**.

