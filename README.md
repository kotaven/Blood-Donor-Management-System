Blood Donor Management System

Introduction

The Blood Donor Management System is a web application designed to manage blood donors, track donation requests, and help people find suitable blood donors easily.

Features

Donor registration with name, blood group, and contact

Search for donors based on blood type with contact number.

Request blood from registered donors.

View donation history.

Admin panel to manage donors and requests.

Technologies Used

Backend: Spring Boot, REST API

Frontend: HTML, CSS, JavaScript

Database: Oracle SQL

Persistence: Spring Data JPA, Hibernate

Tools: Spring Tool Suite (STS), Postman (for API testing)

Build Tool: Maven

Version Control: GitHub

Getting Started

Prerequisites

JDK 17 or later

Maven

Oracle Database 10g or later

Postman (optional, for API testing)

Setup Instructions

Clone the project:

git clone https://github.com/yourusername/blood-donor-management.git
cd blood-donor-management

Configure the database in application.properties:

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update

Build and run the project:

mvn clean install
mvn spring-boot:run

Open the frontend in a browser to access the application.

API Endpoints

Donor Management

Create Donor: POST /api/donors

Get All Donors: GET /api/donors

Get Donor by ID: GET /api/donors/{id}

Update Donor: PUT /api/donors/{id}

Delete Donor: DELETE /api/donors/{id}

Contributing

Contributions are welcome! Follow these steps:

Fork the repository.

Create a new branch: git checkout -b feature/your-feature-name.

Commit your changes: git commit -m 'Add feature'.

Push the branch: git push origin feature/your-feature-name.

Open a pull request.

License

This project is open-source and licensed under the MIT License.

Contact

For any queries or support, contact:

Email: kotavenkatesh2618@gmail.com

